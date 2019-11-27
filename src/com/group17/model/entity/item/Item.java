package com.group17.model.entity.item;

public abstract class Item {
    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    public Item() {

    }
}
