package com.group17.model.world;

import com.group17.core.Position;
import com.group17.model.GameObject;

public abstract class Cell extends GameObject {
    private boolean walkable;

    public Cell(Position position, boolean walkable) {
        super(position);
        this.walkable = walkable;
    }
}
