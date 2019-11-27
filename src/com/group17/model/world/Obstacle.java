package com.group17.model.world;

import com.group17.model.entity.item.Item;

public abstract class Obstacle extends Cell {
    private Item counterItem;

    public Obstacle(Item counterItem) {
        super(true);
        this.counterItem = counterItem;
    }

    public Item getCounterItem() {
        return counterItem;
    }
}
