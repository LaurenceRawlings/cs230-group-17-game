package com.group17.game.model.world;

import com.group17.game.model.entity.item.Item;

public abstract class Obstacle extends Cell {
    private Item counterItem;

    public Obstacle(Item counterItem, String spriteName) {
        super(false, spriteName);
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
