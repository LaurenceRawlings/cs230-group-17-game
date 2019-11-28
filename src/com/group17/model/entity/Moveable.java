package com.group17.model.entity;

import com.group17.core.Position;

public interface Moveable {
    enum Direction {
        up,
        down,
        left,
        right
    }

    void move(Direction direction);

    Position getPosition();
    void setPosition(Position position);
}
