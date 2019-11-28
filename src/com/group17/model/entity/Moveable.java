package com.group17.model.entity;

import com.group17.core.Position;

public interface Moveable {
    enum Direction {
        up,
        down,
        left,
        right
    }

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    Position getPosition();
    void setPosition(Position position);
}
