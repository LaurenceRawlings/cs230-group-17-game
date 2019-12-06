/**
 * Item class is the father class for all in game items available to the player.
 * @author
 */
package com.group17.model.entity.item;

import com.group17.model.GameObject;

import java.util.Objects;

public abstract class Item extends GameObject {
    private String name;
    
    /**
     * Method determines wether the current object is the same as another.
     * @param obj
     * @return true or false depending on wether they are equal or not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    /**
     * Returns the hash code for each item
     * @return hash of the name
     */
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Sets the item.
     * @param name
     * @param spriteName
     */
    
    public Item(String name, String spriteName) {
        super(spriteName);
        this.name = name;
    }
    
    /**
     * Method to return the name of the item
     * @return name
     */

    @Override
    public String toString() {
        return name;
    }
}
