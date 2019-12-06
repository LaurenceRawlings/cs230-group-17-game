package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Direction;

public class WallFollowingEnemy extends Enemy {
    public WallFollowingEnemy(Position position, Direction direction) {
        super(EnemyType.wall, position, direction);
    }

    @Override
    public Position moveHelper(Direction direction) { //gets the wall our enemy is attached to, which is the one to the left of it based on enemy's rotation (direction)
        Position inDir = moveInDir(getDirection());
        if (getPosition().x() == inDir.x()) { //y changed - we intend on moving vertically so the wall will be horizontal to us
            if (inDir.y() > getPosition().y()){
                return new Position(getPosition().x()+1, getPosition().y());
            } else {
                return new Position(getPosition().x()-1, getPosition().y());
            }

        } else if (getPosition().y() == inDir.y()){ //x changed
            if (inDir.x() > getPosition().x()){
                return new Position(getPosition().x(), getPosition().y()-1);
            } else {
                return new Position(getPosition().x(), getPosition().y()+1);
            }
        }
        return null; //should never happen
    }

}
