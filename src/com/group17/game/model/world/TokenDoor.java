/**
 * Class representing the token variation of a door.
 * @author
 */

package com.group17.game.model.world;

public class TokenDoor extends Cell {
    private final int tokenCost;

    public TokenDoor(int tokenCost) {
        super(false, "door_token");
        this.tokenCost = tokenCost;
    }
    
    /**
     * Method to get the cost in keys for the door to open
     * @return tokenCost
     */

    public int getTokenCost() {
        return tokenCost;
    }
}
