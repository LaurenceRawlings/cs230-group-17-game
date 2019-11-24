package com.group17.model.entity;

import com.group17.core.Position;

public class Boots extends Item {
    public enum BootType{
        fire,
        water
    }

    private BootType bootType;

    public Boots(BootType bootType, Position position) {
        super(ItemType.boots, position);
        this.bootType = bootType;
    }

    public BootType getBootType() {
        return bootType;
    }
}
