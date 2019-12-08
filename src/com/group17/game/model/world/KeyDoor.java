/**
 * Class representing a key door.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.Key;

public abstract class KeyDoor extends Cell {
    private final Key.KeyType key;
    
    /**
     * Method sets the key
     * @param key
     * @param spriteName
     */

    KeyDoor(Key.KeyType key, String spriteName) {
        super(false, spriteName);
        this.key = key;
    }
    
    /**
     * Method for getting the key
     * @return key
     */

    public Key.KeyType getKey() {
        return key;
    }
}
