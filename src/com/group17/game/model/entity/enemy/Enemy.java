package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;

import java.io.Serializable;

public abstract class Enemy implements Serializable {
    public enum EnemyType {
        smart("enemy_smart"),
        dumb("enemy_dumb"),
        wall("enemy_wall"),
        line("enemy_line");

        private final String spriteName;

        EnemyType(String label) {
            this.spriteName = label;
        }

        public String getSpriteName() {
            return spriteName;
        }
    }

    private Position position;
    private Direction direction;
    private EnemyType enemyType;

    public Enemy(EnemyType enemyType, Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        this.enemyType = enemyType;
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

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
