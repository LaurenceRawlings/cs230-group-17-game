package com.group17.model.entity.item;

import com.group17.model.GameObject;

import java.util.Objects;

public abstract class Item extends GameObject {
    private String name;

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Item(String name, String spriteName) {
        super(spriteName);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
