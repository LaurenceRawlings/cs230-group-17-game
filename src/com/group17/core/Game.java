package com.group17.core;

import com.group17.model.entity.Direction;
import com.group17.model.entity.Player;
import com.group17.model.entity.enemy.*;
import com.group17.model.world.Cell;
import com.group17.model.world.Ground;
import com.group17.model.world.Level;

import java.io.Serializable;
import java.util.List;
import java.util.PriorityQueue;

public class Game implements Serializable {
    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
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
        levelQueue = new PriorityQueue<>();
        levelQueue.addAll(LevelReader.readLevels());
        currentLevel = levelQueue.poll();
        player = new Player(currentLevel.getStart());
        //player moves
        moveEnemies();
        currentLevel.updateEnemyPositions(); //update positions _after_ enemy moves
        fov = 15;
    }

    public boolean moveEnemiesHelper(Cell c, Enemy e, Position next){ //checks if next cell is walkable, and sets the enemy to it if it is (its a helper due to repetitive use)
        if (c.isWalkable() && c instanceof Ground){
            e.setPosition(next); //position is valid, set and break
            return true;
        } else {
            return false; //to enable the outside caller to produce a new (next) position before applying an invalid move
        }
    }

    public void moveEnemies(){
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
                        if (nextCell.isWalkable() && nextCell instanceof Ground){
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
                //toImplement
            }
        }
    }

    public boolean nextLevel() {
        if (levelQueue.peek() != null) {
            currentLevel = levelQueue.poll();
            return true;
        } else {
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
//        Cell nextCell = currentLevel.getCell(next);
//        if(!currentLevel.getEnemy(next)){
//            if (nextCell.isWalkable()) {
//                if (nextCell instanceof Ground) {
//                    player.setPosition(next);
//                } else if (nextCell instanceof Obstacle) {
//                    if (player.hasItem(((Obstacle) nextCell).getCounterItem())) {
//                        player.setPosition(next);
//                    } else {/*die?*/}
//                }
//            }
//            else {
//                if (nextCell instanceof Teleporter) {
//                    player.setPosition(((Teleporter) nextCell).getDestination().getPosition());
//                }
//                if (nextCell instanceof TokenDoor) {
//                    if (player.hasItem(new Token(), ((TokenDoor) nextCell).getTokenCost())) {
//                        ((TokenDoor) nextCell).open();
//                        player.useItem(new Token(), ((TokenDoor) nextCell).getTokenCost());
//                        player.setPosition(next);
//                    }
//                }
//                if (nextCell instanceof KeyDoor) {
//                    if ((player.hasItem(new Key(Key.KeyType.red))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.red)) {
//                        ((KeyDoor) nextCell).open();
//                        player.useItem(new Key(Key.KeyType.red));
//                        player.setPosition(next);
//                    }
//                    if ((player.hasItem(new Key(Key.KeyType.green))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.green)) {
//                        ((KeyDoor) nextCell).open();
//                        player.useItem(new Key(Key.KeyType.green));
//                        player.setPosition(next);
//                    }
//                    if ((player.hasItem(new Key(Key.KeyType.blue))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.blue)) {
//                        ((KeyDoor) nextCell).open();
//                        player.useItem(new Key(Key.KeyType.blue));
//                        player.setPosition(next);
//                    }
//                }
//            }
//        } else {
//
//        }
    }

}
