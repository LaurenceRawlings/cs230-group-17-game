package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.GameObject;
import com.group17.model.entity.Direction;

import java.io.Serializable;

public abstract class Enemy extends GameObject implements Serializable {
    public enum EnemyType {
        smart,
        dumb,
        wall,
        line
    }

    private Position position;
    private Direction direction;

    public Enemy(Position position, Direction direction, String spriteName) {
        super(spriteName);
        this.position = position;
        this.direction = direction;
    }

    public Position moveInDir(Direction direction) {
        switch (direction){
            case up :
                return new Position(getPosition().x(), getPosition().y()-1);
            case down :
                return new Position(getPosition().x(), getPosition().y()+1);
            case left :
                return new Position(getPosition().x()-1, getPosition().y());
            case right :
                return new Position(getPosition().x()+1, getPosition().y());
        }
        return null;
    }

    public Position moveHelper(Direction direction){
        return null;
    }

    public void rotateRight(){
        switch (getDirection()){
            case up:
                setDirection(Direction.right);
            case left:
                setDirection(Direction.up);
            case down:
                setDirection(Direction.left);
            case right:
                setDirection(Direction.down);
        }
    }

    public void rotateLeft(){
        switch (getDirection()){
            case up:
                setDirection(Direction.left);
            case left:
                setDirection(Direction.down);
            case down:
                setDirection(Direction.right);
            case right:
                setDirection(Direction.up);
        }
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
