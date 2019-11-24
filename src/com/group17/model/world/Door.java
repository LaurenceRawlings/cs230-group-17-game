package com.group17.model.world;

import com.group17.core.Position;

public abstract class Door extends Cell{
    public Door(Position position) {
        super(position, false);
    }
}
