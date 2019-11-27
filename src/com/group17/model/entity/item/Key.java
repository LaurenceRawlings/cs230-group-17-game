package com.group17.model.entity.item;

public class Key extends Item {
    public enum KeyType{
        red("Red"),
        green("Green"),
        blue("Blue");

        public final String label;

        KeyType(String label) {
            this.label = label;
        }
    }

    private KeyType keyType;

    public Key(KeyType keyType) {
        super(keyType.label + " Key");
        this.keyType = keyType;
    }

    public KeyType getKeyType() {
        return keyType;
    }
}
