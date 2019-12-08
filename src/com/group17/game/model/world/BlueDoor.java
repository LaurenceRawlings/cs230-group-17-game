/**
 * Class representing the blue door child of KeyDoor.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.Key;

public class BlueDoor extends KeyDoor {
    public BlueDoor() {
        super(Key.KeyType.blue, "door_blue");
    }
}
