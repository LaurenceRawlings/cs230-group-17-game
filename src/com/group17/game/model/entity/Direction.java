/**
 * This class defines the four enums for direction
 * @author
 */
package com.group17.game.model.entity;

public enum Direction {
    up,
    down,
    left,
    right;

    public Direction flip() {
        switch (this){
            case up :
                return Direction.down;
            case down :
                return Direction.up;
            case left :
                return Direction.right;
            case right :
                return Direction.left;
        }

        return null;
    }

    public Direction rotateRight() {
        switch (this){
            case up :
                return Direction.right;
            case down :
                return Direction.left;
            case left :
                return Direction.up;
            case right :
                return Direction.down;
        }

        return null;
    }

    public Direction relative(Direction facing) {
        switch (facing){
            case up :
                return this;
            case down :
                return this.flip();
            case left :
                return this.rotateRight().flip();
            case right :
                return this.rotateRight();
        }

        return null;
    }
}
