/**
 * Class defining position. Used for objects in game to set and get their x and y coordinates. 
 * @author
 */

package com.group17.game.core;

import com.group17.game.model.entity.Direction;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private final int x;
    private final int y;
    
    /**
	 * Method setting the position
	 * @param x
	 * @param y
	 */

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
	 * Method to get x coordinate
	 * @return x
	 */
    
    public int x() {
        return x;
    }
    
    /**
	 * Method to get y coordinate
	 * @return y
	 */

    public int y() {
        return y;
    }
    
    /**
	 * Method to determine if coordinates of different objects are the same
	 * @param o is the other object to be compared
	 * @return true or false
	 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
    
    /**
	 * Method to get the hash code of the x and y coordinates
	 * @return hash(x, y) of an object
	 */

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    /**
	 * Method gets the next position for an entity to go based on the direction input
	 * and the current position
	 * @param currentPosition
	 * @param direction
	 * @return next which is the next position
	 */

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
