package com.group17.core;

import java.io.Serializable;

public class Profile implements Serializable, Comparable<Profile> {
    private Game game;
    private String name;
    private int highscore;

    public Game getGame() {
        return game;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String getName() {
        return name;
    }

    public Profile(String name) {
        this.name = name;
        highscore = 0;
        game = new Game();
    }

    public void newGame() {
        game = new Game();
    }

    @Override
    public int compareTo(Profile profile) {
        if (highscore == profile.getHighscore()) {
            return 0;
        } else if (highscore < profile.getHighscore()) {
            return 1;
        } else {
            return -1;
        }
    }
}
