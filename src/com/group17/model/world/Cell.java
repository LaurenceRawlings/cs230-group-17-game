package com.group17.model.world;

import java.io.Serializable;

public abstract class Cell implements Serializable {
    private boolean walkable;

    public Cell(boolean walkable) {
        this.walkable = walkable;
    }
    public boolean isWalkable (){
        return this.walkable;
    }
}
