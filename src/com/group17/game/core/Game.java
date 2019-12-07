package com.group17.game.core;

import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.entity.enemy.*;
import com.group17.game.model.entity.item.Item;
import com.group17.game.model.entity.item.Key;
import com.group17.game.model.entity.item.Token;
import com.group17.game.model.world.*;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {
    private List<Level> levelQueue;
    private Level currentLevel;
    private int levelIndex;
    private Player player;
    private int fov;

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
    public Player getPlayer() {
        return player;
    }


    public Game() {
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(0);
        levelIndex = 0;
        player = new Player(currentLevel.getStart());
        fov = 3;
    }

    public Game(int levelIndex) {
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(levelIndex);
        this.levelIndex = levelIndex;
        player = new Player(currentLevel.getStart());
        fov = 3;
    }


    public boolean moveEnemiesHelper(Cell c, Enemy e, Position next){ //checks if next cell is walkable, and sets the enemy to it if it is (its a helper due to repetitive use)
        if (c instanceof Ground){
            e.setPosition(next); //position is valid, set and break
            return true;
        } else {
            return false;
        }
    }

    public void moveEnemies(){
        Node[][] nodeMap = new Node[currentLevel.getWidth() - 1][currentLevel.getHeight() - 1];

        List<Enemy> enemiesL = currentLevel.getEnemies();
        for (Enemy e : enemiesL){
            if(e instanceof LineFollowingEnemy){
                Position next = e.moveInDir(e.getDirection()); //proposed move
                while(true) {
                    if (moveEnemiesHelper(currentLevel.getCell(next), e, next)){
                        break;
                    } else {
                        next = e.moveHelper(e.getDirection()); //position is invalid and we try another one supplied by algorithm
                    }           //NOTE: e.moveHelper does different things depending on which subclass of Enemy overrides it.
                }
            }
            if(e instanceof DumbFollowingEnemy) {
                int xDif = (e.getPosition().x() - player.getPosition().x());
                int yDif = (e.getPosition().y() - player.getPosition().y());
                int triedx = 0;
                int triedy = 0;
                for (int i = 0; i < 2; i++) {
                    if (Math.abs(xDif) > Math.abs(yDif) && triedx != 1) { //more difference on the x
                        Position next = null;
                        if (xDif > 0) {
                            next = new Position(e.getPosition().x() - 1, e.getPosition().y());
                            if(moveEnemiesHelper(currentLevel.getCell(next), e, next)){break;} //if returns true then we moved successfully - and we can break, essentially one of them will break
                        } // the if under main for-loop is used to prioritise movement on the axis that have the most discrepancy from player
                            //the triedx and triedy are there since its a dumb-enemy, and will often be in situations where it will not be able to move, so we only try each axis once
                        if (xDif < 0) {
                            next = new Position(e.getPosition().x() + 1, e.getPosition().y());
                            if(moveEnemiesHelper(currentLevel.getCell(next), e, next)){break;}
                        }
                        if (xDif == 0) {
                        }
                        triedx = 1;

                    }
                    if (Math.abs(xDif) < Math.abs(yDif) && triedy != 1) { //more difference on the y
                        Position next = null;
                        if (yDif > 0) {
                            next = new Position(e.getPosition().x(), e.getPosition().y() - 1);
                            if(moveEnemiesHelper(currentLevel.getCell(next), e, next)){break;}
                        }
                        if (yDif < 0) {
                            next = new Position(e.getPosition().x(), e.getPosition().y() + 1);
                            if(moveEnemiesHelper(currentLevel.getCell(next), e, next)){break;}
                        }
                        triedy = 1;
                    }
                }
            }
            if(e instanceof WallFollowingEnemy) {
                while(true) {
                    Position attachedWall = e.moveHelper(e.getDirection()); //get attached wall pos (more info in WallFollowingEnemy @Override)
                    Position next = e.moveInDir(e.getDirection());
                    Cell nextCell = currentLevel.getCell(next);
                    Cell wallCell = currentLevel.getCell(attachedWall);
                    if (!wallCell.isWalkable()){ //check if we are still attached to a wall/unwalkable object(door/fire/etc)
                        if (nextCell instanceof Ground){
                            e.setPosition(next); //position is valid, set and break
                            break;
                        } else { //there's an obstruction, rotate right 90
                            e.rotateRight();
                        }
                    } else { //if the cell to the left is walkable then we need to rotate left 90 and move forward
                        e.rotateLeft();
                        e.setPosition(e.moveInDir(e.getDirection())); //set position straight away because we know that its walkable already
                    }
                }

            }
            if(e instanceof SmartFollowingEnemy) {
                Graph graph = new Graph();
                for (int i = 0; i < currentLevel.getWidth(); i++) { //populating our arrays of nodes
                    for (int j = 0; j < currentLevel.getHeight(); j++) {
                        if (currentLevel.getCell(new Position(i,j)) instanceof Ground) { //if walkable and ground
                            nodeMap[i][j] = new Node(new Position(i,j));
                        }
                    }
                }

                for (int i = 0; i < currentLevel.getWidth(); i++){ //populating our graph with edges vertically
                    for (int j = 0; j < currentLevel.getHeight(); j++){
                        if (currentLevel.getCell(new Position(i,j)) != null && currentLevel.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
                            if (currentLevel.getCell(new Position(i+1,j)) != null && currentLevel.getCell(new Position(i+1,j)) instanceof Ground) { //if cell under it is walkable and ground
                                graph.addEdge(nodeMap[i][j], nodeMap[i+1][j]); //join both cells in an edge
                            }
                        } //else not walkable so we skip
                    }
                }
                for (int j = 0; j < currentLevel.getHeight(); j++){ //populating our graph with edges horizontally
                    for (int i = 0; i < currentLevel.getWidth(); i++){
                        if (currentLevel.getCell(new Position(i,j)) != null && currentLevel.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
                            if (currentLevel.getCell(new Position(i,j+1)) != null && currentLevel.getCell(new Position(i,j+1)) instanceof Ground) { //if cell under it is walkable and ground
                                graph.addEdge(nodeMap[i][j], nodeMap[i][j+1]); //join both cells in an edge
                            }
                        } //else not walkable so we skip
                    }
                }

                graph.breadthFirstSearch(nodeMap[player.getPosition().x()][player.getPosition().y()]); //generate all paths starting from player's position

                LinkedList<Node> shortestPath = graph.findShortestPathHelper(nodeMap[player.getPosition().x()][player.getPosition().y()], nodeMap[e.getPosition().x()][e.getPosition().y()]); //
                if (shortestPath == null){
                    System.out.println("Enemy doesn't know how to get to player");
                } else {
                    Position next = shortestPath.get(shortestPath.size() - 2).getPos(); //list will generate nodes from player to enemy so we take
                                                                        // the second to last which will be the next cell enemy will want to move to
                    moveEnemiesHelper(currentLevel.getCell(next), e, next); //set position to next
                }
            }
        }
    }

    public boolean nextLevel() {
        try {
            currentLevel = levelQueue.get(++levelIndex);
            player = new Player(currentLevel.getStart());
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void move(Direction direction) {
        Position next = null;
        switch (direction) {
            case right:
                next = new Position(player.getPosition().x() + 1, player.getPosition().y());
                break;
            case left:
                next = new Position(player.getPosition().x() - 1, player.getPosition().y());
                break;
            case up:
                next = new Position(player.getPosition().x(), player.getPosition().y() - 1);
                break;
            case down:
                next = new Position(player.getPosition().x(), player.getPosition().y() + 1);
                break;
        }

        if (canMove(next)) {
            player.setPosition(next);
            Position current = player.getPosition();
            Item item = currentLevel.getItem(current);
            Cell cell = currentLevel.getCell(current);
            if (item != null) {
                player.pickUp(item);
                currentLevel.setItem(current, null);
            }
            if (cell instanceof Teleporter) {
                player.setPosition(((Teleporter) currentLevel.getCell(current)).getDestination().getPosition());
            }
            moveEnemies();
            if (currentLevel.getEnemy(current) != null) {
                die();
            }
        }
    }

    private boolean canMove(Position nextPosition) {
        Cell cell = currentLevel.getCell(nextPosition);
        if (cell.isWalkable()) {
            return true;
        } else {
            if (cell instanceof KeyDoor) {
                Key key = new Key(((KeyDoor) cell).getKey());
                if (player.hasItem(key)) {
                    currentLevel.setCell(nextPosition, new Ground());
                    player.useItem(key);
                    return true;
                }
            } else if (cell instanceof TokenDoor) {
                Token token = new Token();
                int cost = ((TokenDoor) cell).getTokenCost();
                if (player.hasItem(token, cost)) {
                    currentLevel.setCell(nextPosition, new Ground());
                    player.useItem(token, cost);
                    return true;
                }
            } else if (cell instanceof Obstacle) {
                if (player.hasItem(((Obstacle) cell).getCounterItem())) {
                    return true;
                }
            }
            if (currentLevel.getEnemy(nextPosition) != null) {
                player.setPosition(nextPosition);
                die();
                return false;
            }
        }
        return false;
    }

    private void die() {
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(levelIndex);
        player = new Player(currentLevel.getStart());
    }

}