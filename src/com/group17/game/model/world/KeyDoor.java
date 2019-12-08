package com.group17.game.model.world;

import com.group17.game.model.entity.item.Key;

public abstract class KeyDoor extends Cell {
    private final Key.KeyType key;

    KeyDoor(Key.KeyType key, String spriteName) {
        super(false, spriteName);
        this.key = key;
    }

    public Key.KeyType getKey() {
        return key;
    }
}
