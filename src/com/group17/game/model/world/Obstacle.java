package com.group17.game.model.world;

import com.group17.game.model.entity.item.Item;

public abstract class Obstacle extends Cell {
    private final Item counterItem;

    Obstacle(Item counterItem, String spriteName) {
        super(false, spriteName);
        this.counterItem = counterItem;
    }

    public Item getCounterItem() {
        return counterItem;
    }
}
