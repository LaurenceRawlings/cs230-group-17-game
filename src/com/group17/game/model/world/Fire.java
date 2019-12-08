/**
 * Class representing a fire cell.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.FireBoots;

public class Fire extends Obstacle {
    public Fire() {
        super(new FireBoots(), "obstacle_fire");
    }
}
