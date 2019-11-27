package com.group17.model.entity.item;

public abstract class Item {
    private String name;

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
