package com.group17.model.entity;

import com.group17.core.Position;
import com.group17.model.GameObject;

public abstract class Enemy extends GameObject {
    public Enemy(Position position) {
        super(position);
    }
}
