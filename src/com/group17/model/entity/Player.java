package com.group17.model.entity;

import com.group17.core.Position;

import java.io.Serializable;

public class Player implements Moveable, Serializable {
    private Position position;

    public Player(Position position) {

    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
