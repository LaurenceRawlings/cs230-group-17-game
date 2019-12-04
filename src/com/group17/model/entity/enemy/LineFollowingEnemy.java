package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Direction;

public class LineFollowingEnemy extends Enemy {
    public LineFollowingEnemy(Position position, Direction direction) {
        super(position, direction, "enemy_line");
    }

    @Override
    public Position moveHelper(Direction direction){
        switch (direction){ //This helper sets the opposite direction and tries to "move" one in the opposite direction)
            case up :
                setDirection(Direction.down);
                return new Position(getPosition().x(), getPosition().y()+1);
            case down :
                setDirection(Direction.up);
                return new Position(getPosition().x(), getPosition().y()-1);
            case left :
                setDirection(Direction.right);
                return new Position(getPosition().x()+1, getPosition().y());
            case right :
                setDirection(Direction.left);
                return new Position(getPosition().x()-1, getPosition().y());
        }
        return null;  //should never happen
        // There will be an infinite loop if the enemy is initialised a position where it cannot move in its desired axis (vertical/horizontal)
                                            // I don't know if we want to check for this and just break the loop after x unsuccessful attempts
    }
}
