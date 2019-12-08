package com.group17.game.model.world;

import com.group17.game.model.GameObject;

public abstract class Cell extends GameObject {
    private final boolean walkable;

    Cell(boolean walkable, String spriteName) {
        super(spriteName);
        this.walkable = walkable;
    }
    public boolean isWalkable (){
        return this.walkable;
    }
}
