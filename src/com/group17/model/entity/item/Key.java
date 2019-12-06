package com.group17.model.entity.item;

import java.util.Objects;

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
                setSpriteName("key_red");
                break;
            case green:
                setSpriteName("key_green");
                break;
            case blue:
                setSpriteName("key_blue");
                break;
            default:
                break;
        }
    }

    public KeyType getKeyType() {
        return keyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Key key = (Key) o;
        return keyType == key.keyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keyType);
    }
}
