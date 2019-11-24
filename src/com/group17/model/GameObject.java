package com.group17.model;

import com.group17.core.Position;

public abstract class GameObject {
    private Position position;

    public GameObject(Position position) {
        this.position = position;
    }
}
