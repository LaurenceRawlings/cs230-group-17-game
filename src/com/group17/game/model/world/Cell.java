/**
 * Class representing a cell.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.GameObject;

public abstract class Cell extends GameObject {
    private final boolean walkable;

    /**
     * Method allows cell to be walkable depending on the sprite
     * @param walkable
     * @param spriteName
     */
    
    Cell(boolean walkable, String spriteName) {
        super(spriteName);
        this.walkable = walkable;
    }
    
    /**
     * Method to return if a sprite is walkable or not
     * @return true or false
     */
    
    public boolean isWalkable (){
        return this.walkable;
    }
}
