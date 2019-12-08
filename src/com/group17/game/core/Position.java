package com.group17.game.core;

import com.group17.game.model.entity.Direction;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private final int x;
    private final int y;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static Position nextPosition(Position currentPosition, Direction direction) {
        Position next = null;
        switch (direction) {
            case right:
                next = new Position(currentPosition.x() + 1, currentPosition.y());
                break;
            case left:
                next = new Position(currentPosition.x() - 1, currentPosition.y());
                break;
            case up:
                next = new Position(currentPosition.x(), currentPosition.y() - 1);
                break;
            case down:
                next = new Position(currentPosition.x(), currentPosition.y() + 1);
                break;
        }

        return next;
    }

}
