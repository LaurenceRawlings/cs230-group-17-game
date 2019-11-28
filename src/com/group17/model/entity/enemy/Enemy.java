package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Moveable;

import java.io.Serializable;

public abstract class Enemy implements Moveable, Serializable {
    public enum EnemyType {
        smart,
        dumb,
        wall,
        line
    }

    private Position position;
    private Direction direction;

    public Enemy(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
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
