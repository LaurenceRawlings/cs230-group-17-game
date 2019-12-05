package com.group17.model.world;

import com.group17.model.GameObject;

public abstract class Cell extends GameObject {
    private boolean walkable;

    public Cell(boolean walkable, String spriteName) {
        super(spriteName);
        this.walkable = walkable;
    }
    public boolean isWalkable (){
        return this.walkable;
    }
}
