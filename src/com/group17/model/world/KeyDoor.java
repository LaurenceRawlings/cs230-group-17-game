package com.group17.model.world;

import com.group17.model.entity.item.Key;

public abstract class KeyDoor extends Cell {
    private Key.KeyType key;

    public KeyDoor(Key.KeyType key, String spriteName) {
        super(false, spriteName);
        this.key = key;
    }

    public Key.KeyType getKey() {
        return key;
    }
}
