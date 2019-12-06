package com.group17.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Profile implements Serializable, Comparable<Profile> {
    private Game game;
    private String name;
    private Map levelTimes = new HashMap();

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

    public String getName() {
        return name;
    }

    public Profile(String name) {
        this.name = name;
        game = new Game();
    }

    public void newGame() {
        game = new Game();
    }

    @Override
    public int compareTo(Profile profile) {
        String compareLevel = Leaderboard.getCompareLevel();

        if (compareLevel == null) {
            return 0;
        }

        if (getLevelTime(compareLevel) == profile.getLevelTime(compareLevel)) {
            return 0;
        } else if (getLevelTime(compareLevel) > profile.getLevelTime(compareLevel)) {
            return 1;
        } else {
            return -1;
        }
    }
}
