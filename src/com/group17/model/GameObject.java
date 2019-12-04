package com.group17.model;

import java.io.Serializable;

public abstract class GameObject implements Serializable {

    private String spriteName;

    public String getSpriteName() {
        return spriteName;
    }

    protected void setSpriteName(String spriteName) {
        this.spriteName = spriteName;
    }

    public GameObject(String spriteName) {
        setSpriteName(spriteName);
    }
}
