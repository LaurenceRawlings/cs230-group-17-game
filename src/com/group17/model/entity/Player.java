package com.group17.model.entity;

import com.group17.core.Position;

import java.io.Serializable;

public class Player implements Serializable {
    private Position position;

    public Player(Position position) {
    }
    public void setPosition(Position position){
        this.position=position;
    }
    public Position getPosition() {
        return this.position;
    }
}
