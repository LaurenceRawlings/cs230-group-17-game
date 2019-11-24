package com.group17.model;

public abstract class Item extends GameObject {
    public enum ItemType{
        key,
        token,
        boots
    }

    private ItemType itemType;

    public Item(ItemType itemType, Position position) {
        super(position);
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
