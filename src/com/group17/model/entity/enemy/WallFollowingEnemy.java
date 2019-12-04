package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Direction;

public class WallFollowingEnemy extends Enemy {
    public WallFollowingEnemy(Position position, Direction direction) {
        super(position, direction, "enemy_wall");
    }

    @Override
    public Position moveHelper(Direction direction) { //gets the wall our enemy is attached to, which is the one to the left of it based on enemy's rotation (direction)
        Position inDir = moveInDir(getDirection());
        if (getPosition().x() == inDir.x()) { //y changed
            if (inDir.x() > getPosition().x()){
                return new Position(getPosition().x(), getPosition().y()+1);
            } else {
                return new Position(getPosition().x(), getPosition().y()-1);
            }

        } else if (getPosition().y() == inDir.y()){ //x changed
            if (inDir.y() > getPosition().y()){
                return new Position(getPosition().x()-1, getPosition().y());
            } else {
                return new Position(getPosition().x()+1, getPosition().y());
            }
        }
        return null; //should never happen
    }

}
