package com.group17.model.entity.item;

import java.io.Serializable;

public abstract class Item implements Serializable {
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
