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
        super(keyType.label + " Key", "missing_item");
        this.keyType = keyType;
        switch (keyType) {
            case red:
                setSprite("key_red");
                break;
            case green:
                setSprite("key_green");
                break;
            case blue:
                setSprite("key_blue");
                break;
            default:
                break;
        }
    }

    public KeyType getKeyType() {
        return keyType;
    }
}
