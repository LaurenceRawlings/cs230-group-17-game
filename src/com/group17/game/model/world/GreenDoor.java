/**
 * Class representing the green door child of KeyDoor.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.Key;

public class GreenDoor extends KeyDoor {
    public GreenDoor() {
        super(Key.KeyType.green, "door_green");
    }
}
