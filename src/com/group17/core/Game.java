package com.group17.core;

import com.group17.model.entity.Player;
import com.group17.model.world.Level;

import java.util.PriorityQueue;

public class Game {
    public PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;
    private Profile profile;

    public Game(Profile profile) {
        this.profile = profile;
        levelQueue = new PriorityQueue<>();
        levelQueue.addAll(LevelReader.readLevels());
    }

}
