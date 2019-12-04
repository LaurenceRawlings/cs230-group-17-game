package com.group17.model.world;

import com.group17.model.entity.item.Item;

public abstract class Obstacle extends Cell {
    private Item counterItem;

    public Obstacle(Item counterItem, String spriteName) {
        super(true, spriteName);
        this.counterItem = counterItem;
    }

    public Obstacle(String spriteName) {
        super(true, spriteName);
        counterItem = null;
    }

    public Item getCounterItem() {
        return counterItem;
    }
}
