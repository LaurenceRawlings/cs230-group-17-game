package com.group17.model.entity.item;

public class Key extends Item {
    public enum KeyType{
        red,
        green,
        blue
    }

    private KeyType keyType;

    public Key(KeyType keyType) {
        this.keyType = keyType;
    }

    public KeyType getKeyType() {
        return keyType;
    }
}
