package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Ground;
import com.group17.game.model.world.Level;

import java.io.Serializable;

public abstract class Enemy implements Serializable {
    public abstract void move(Player player);

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

    protected Position position;
    protected Direction direction;
    protected EnemyType enemyType;
    protected Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Enemy(EnemyType enemyType, Position position, Direction direction, Level level) {
        this.position = position;
        this.direction = direction;
        this.enemyType = enemyType;
        this.level = level;
    }

    protected boolean move(Position nextPosition) {
        if (canMove(nextPosition)) {
            position = nextPosition;
            return true;
        } else {
            return false;
        }
    }

    public boolean canMove(Position nextPosition){
        return level.getCell(nextPosition) instanceof Ground;
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
