package com.group17.model.world;

import com.group17.model.entity.item.Key;

public class KeyDoor extends Door {
    private Key.KeyType key;

    public KeyDoor(Key.KeyType key) {
        this.key = key;
    }
}
