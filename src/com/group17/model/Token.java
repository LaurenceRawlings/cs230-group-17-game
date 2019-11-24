package com.group17.model;

public class Token extends Item {
    private int tokenValue;

    public Token(Position position) {
        super(ItemType.token, position);
        tokenValue = 1;
    }

    public Token(Position positions, int tokenValue) {
        super(ItemType.token, positions);
        this.tokenValue = tokenValue;
    }

    public int getTokenValue() {
        return tokenValue;
    }
}
