package com.group17.model;

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
