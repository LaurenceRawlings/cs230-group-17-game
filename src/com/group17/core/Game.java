package com.group17.core;

import com.group17.model.entity.Moveable;
import com.group17.model.entity.Player;
import com.group17.model.world.Level;

import java.io.Serializable;
import java.util.PriorityQueue;

public class Game implements Serializable {
    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;

    public Game() {
        levelQueue = new PriorityQueue<>();
        levelQueue.addAll(LevelReader.readLevels());
        currentLevel = levelQueue.poll();
        assert currentLevel != null;
        player = new Player(currentLevel.getStart());
    }

    public void move(Moveable.Direction direction) {
        switch (direction) {
            case up:
                break;
            case down:
                break;
            case left:
                break;
            case right:
                break;
        }
    }
}
