package com.group17.model.entity;

import com.group17.core.Position;

public class Key extends Item {
    public enum KeyType{
        red,
        green,
        blue
    }

    private KeyType keyType;

    public Key(KeyType keyType, Position position) {
        super(ItemType.key, position);
        this.keyType = keyType;
    }

    public KeyType getKeyType() {
        return keyType;
    }
}
