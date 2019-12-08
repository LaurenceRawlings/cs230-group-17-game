/**
 * Class defines an obstacle cell.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.Item;

public abstract class Obstacle extends Cell {
    private final Item counterItem;
    
    /**
     * Method sets the counter item
     * @param counterItem
     * @param spriteName
     */

    Obstacle(Item counterItem, String spriteName) {
        super(false, spriteName);
        this.counterItem = counterItem;
    }
    
    /**
     * Method to get the counter item
     * @return counterItem
     */

    public Item getCounterItem() {
        return counterItem;
    }
}
