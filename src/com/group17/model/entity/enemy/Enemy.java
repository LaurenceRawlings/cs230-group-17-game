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
                setDirection(Moveable.Direction.right);
            case left:
                setDirection(Moveable.Direction.up);
            case down:
                setDirection(Moveable.Direction.left);
            case right:
                setDirection(Moveable.Direction.down);
        }
    }

    public void rotateLeft(){
        switch (getDirection()){
            case up:
                setDirection(Moveable.Direction.left);
            case left:
                setDirection(Moveable.Direction.down);
            case down:
                setDirection(Moveable.Direction.right);
            case right:
                setDirection(Moveable.Direction.up);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
