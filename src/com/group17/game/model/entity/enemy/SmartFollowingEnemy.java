package com.group17.game.model.entity.enemy;

import com.group17.game.core.Graph;
import com.group17.game.core.Node;
import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Ground;
import com.group17.game.model.world.Level;

import java.util.LinkedList;

public class SmartFollowingEnemy extends Enemy {
    private Position nextPosition;

    public SmartFollowingEnemy(Position position, Direction direction, Level level, Position initialTarget) {
        super(EnemyType.smart, position, direction, level);
        calculatePath(new Player(initialTarget));
    }

    @Override
    public void move(Player player) {
        move(nextPosition);
        calculatePath(player);
    }

    private void calculatePath(Player player) {
        Node[][] nodeMap = new Node[level.getWidth() - 1][level.getHeight() - 1];

        Graph graph = new Graph();
        for (int i = 0; i < level.getWidth(); i++) { //populating our arrays of nodes
            for (int j = 0; j < level.getHeight(); j++) {
                if (level.getCell(new Position(i,j)) instanceof Ground) { //if walkable and ground
                    nodeMap[i][j] = new Node(new Position(i,j));
                }
            }
        }

        for (int i = 0; i < level.getWidth(); i++){ //populating our graph with edges vertically
            for (int j = 0; j < level.getHeight(); j++){
                if (level.getCell(new Position(i,j)) != null && level.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
                    if (level.getCell(new Position(i+1,j)) != null && level.getCell(new Position(i+1,j)) instanceof Ground) { //if cell under it is walkable and ground
                        graph.addEdge(nodeMap[i][j], nodeMap[i+1][j]); //join both cells in an edge
                    }
                } //else not walkable so we skip
            }
        }
        for (int j = 0; j < level.getHeight(); j++){ //populating our graph with edges horizontally
            for (int i = 0; i < level.getWidth(); i++){
                if (level.getCell(new Position(i,j)) != null && level.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
                    if (level.getCell(new Position(i,j+1)) != null && level.getCell(new Position(i,j+1)) instanceof Ground) { //if cell under it is walkable and ground
                        graph.addEdge(nodeMap[i][j], nodeMap[i][j+1]); //join both cells in an edge
                    }
                } //else not walkable so we skip
            }
        }

        graph.breadthFirstSearch(nodeMap[player.getPosition().x()][player.getPosition().y()]); //generate all paths starting from player's position

        try {
            LinkedList<Node> shortestPath = graph.findShortestPathHelper(nodeMap[player.getPosition().x()][player.getPosition().y()], nodeMap[position.x()][position.y()]);

            nextPosition = shortestPath.get(1).getPos();

        } catch (NullPointerException e) {
            nextPosition = moveDumb(player);
        }

    }

    public Position moveDumb(Player player) {
        int xDif = (position.x() - player.getPosition().x());
        int yDif = (position.y() - player.getPosition().y());

        if (Math.abs(xDif) >= Math.abs(yDif)) {
            if (!moveX(xDif)) {
                moveY(yDif);
            }
        } else{
            if (!moveY(yDif)) {
                moveX(xDif);
            }
        }
        return super.position;
    }

    private boolean moveX(int xDif) {
        if (xDif > 0) {
            return move(Position.nextPosition(position, Direction.left));
        } else if (xDif < 0) {
            return move(Position.nextPosition(position, Direction.right));
        }

        return false;
    }

    private boolean moveY(int yDif) {
        if (yDif > 0) {
            return move(Position.nextPosition(position, Direction.up));
        } else if (yDif < 0) {
            return move(Position.nextPosition(position, Direction.down));
        }

        return false;
    }

    //
}

