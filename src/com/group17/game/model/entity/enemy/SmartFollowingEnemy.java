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
    public SmartFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.smart, position, direction, level);
    }

    @Override
    public void move(Player player) {
//        Node[][] nodeMap = new Node[currentLevel.getWidth() - 1][currentLevel.getHeight() - 1];
//        if(e instanceof SmartFollowingEnemy) {
//            Graph graph = new Graph();
//            for (int i = 0; i < currentLevel.getWidth(); i++) { //populating our arrays of nodes
//                for (int j = 0; j < currentLevel.getHeight(); j++) {
//                    if (currentLevel.getCell(new Position(i,j)) instanceof Ground) { //if walkable and ground
//                        nodeMap[i][j] = new Node(new Position(i,j));
//                    }
//                }
//            }
//
//            for (int i = 0; i < currentLevel.getWidth(); i++){ //populating our graph with edges vertically
//                for (int j = 0; j < currentLevel.getHeight(); j++){
//                    if (currentLevel.getCell(new Position(i,j)) != null && currentLevel.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
//                        if (currentLevel.getCell(new Position(i+1,j)) != null && currentLevel.getCell(new Position(i+1,j)) instanceof Ground) { //if cell under it is walkable and ground
//                            graph.addEdge(nodeMap[i][j], nodeMap[i+1][j]); //join both cells in an edge
//                        }
//                    } //else not walkable so we skip
//                }
//            }
//            for (int j = 0; j < currentLevel.getHeight(); j++){ //populating our graph with edges horizontally
//                for (int i = 0; i < currentLevel.getWidth(); i++){
//                    if (currentLevel.getCell(new Position(i,j)) != null && currentLevel.getCell(new Position(i,j)) instanceof Ground){ //if walkable and ground
//                        if (currentLevel.getCell(new Position(i,j+1)) != null && currentLevel.getCell(new Position(i,j+1)) instanceof Ground) { //if cell under it is walkable and ground
//                            graph.addEdge(nodeMap[i][j], nodeMap[i][j+1]); //join both cells in an edge
//                        }
//                    } //else not walkable so we skip
//                }
//            }
//
//            graph.breadthFirstSearch(nodeMap[player.getPosition().x()][player.getPosition().y()]); //generate all paths starting from player's position
//
//            LinkedList<Node> shortestPath = graph.findShortestPathHelper(nodeMap[player.getPosition().x()][player.getPosition().y()], nodeMap[e.getPosition().x()][e.getPosition().y()]); //
//            if (shortestPath == null){
//                System.out.println("Enemy doesn't know how to get to player");
//            } else {
//                Position next = shortestPath.get(shortestPath.size() - 2).getPos(); //list will generate nodes from player to enemy so we take
//                // the second to last which will be the next cell enemy will want to move to
//                moveEnemiesHelper(currentLevel.getCell(next), e, next); //set position to next
//            }
//        }
    }
}

