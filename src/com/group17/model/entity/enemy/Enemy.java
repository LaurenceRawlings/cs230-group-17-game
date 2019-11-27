package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Movable;

public abstract class Enemy implements Movable {
    private Position position;

    public Enemy(Position position) {
        this.position = position;
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
