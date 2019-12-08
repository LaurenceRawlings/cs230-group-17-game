package com.group17.game.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Profile implements Serializable, Comparable<Profile> {
    private Game game;
    private final String name;
    private final Map levelTimes;
    private int highestLevel;

    public int getHighestLevel() {
        return highestLevel;
    }

    public void setHighestLevel(int highestLevel) {
        this.highestLevel = highestLevel;
    }

    public int getLevelTime(String levelName) {
        if (levelTimes.containsKey(levelName)) {
            return (int) levelTimes.get(levelName);
        } else {
            return (int) Double.POSITIVE_INFINITY;
        }
    }

    public boolean levelCompleted(String levelName) {
        return levelTimes.containsKey(levelName);
    }

    public void setLevelTime(String levelName, int time) {
        levelTimes.put(levelName, time);
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return name;
    }

    public Profile(String name) {
        this.name = name;
        game = new Game();
        levelTimes = new HashMap();
        highestLevel = -1;
    }

    public void newGame() {
        game = new Game();
    }

    public void newGame(int levelIndex) {
        game = new Game(levelIndex);
    }

    @Override
    public int compareTo(Profile profile) {
        String compareLevel = Leaderboard.getCompareLevel();

        if (compareLevel == null) {
            return 0;
        }

        return Integer.compare(getLevelTime(compareLevel), profile.getLevelTime(compareLevel));
    }
}
