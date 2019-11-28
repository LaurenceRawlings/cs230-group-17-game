package com.group17.core;

import com.group17.model.entity.Moveable;
import com.group17.model.entity.Player;
import com.group17.model.world.Cell;
import com.group17.model.world.Level;

import java.io.Serializable;
import java.util.PriorityQueue;

public class Game implements Serializable {
    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;

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
        assert currentLevel != null;
        player = new Player(currentLevel.getStart());
    }

    public boolean nextLevel() {
        if (levelQueue.peek() != null) {
            currentLevel = levelQueue.poll();
            return true;
        } else {
            return false;
        }
    }

    public void move(Moveable.Direction direction) {
        Position next=null;
        switch(direction){
            case right:
                next = new Position(player.getPosition().x()+1 , player.getPosition().y());
                break;
            case left:
                next = new Position(player.getPosition().x()+1 , player.getPosition().y());
                break;
            case up:
                next=new Position(player.getPosition().x() , player.getPosition().y()-1);
                break;
            case down:
                next =new Position(player.getPosition().x() , player.getPosition().y()+1);
                break;
        }
        Cell nextCell=currentLevel.getCell(next);
        player.setPosition(next);
    }
}
