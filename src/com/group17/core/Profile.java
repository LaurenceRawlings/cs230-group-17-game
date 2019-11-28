package com.group17.core;

import java.io.Serializable;

public class Profile implements Serializable {
    private Game game;
    private String name;

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public String getName() {
        return name;
    }

    private int highscore;

    public Profile(String name) {
        this.name = name;
        highscore = 0;
    }

    public void newGame() {
        game = new Game();
    }
}
