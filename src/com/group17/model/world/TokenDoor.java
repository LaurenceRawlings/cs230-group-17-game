package com.group17.model.world;

public class TokenDoor extends Door {
    private int tokenCost;

    public TokenDoor(int tokenCost) {
        this.tokenCost = tokenCost;
    }

    public int getTokenCost() {
        return tokenCost;
    }
}
