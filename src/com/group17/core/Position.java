package com.group17.core;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
