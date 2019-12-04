package com.group17.model.world;

public class TokenDoor extends Cell {
    private int tokenCost;

    public TokenDoor(int tokenCost) {
        super(false, "door_token");
        this.tokenCost = tokenCost;
    }

    public int getTokenCost() {
        return tokenCost;
    }
}
