/**
 * Class represents a water cell.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.model.entity.item.WaterBoots;

public class Water extends Obstacle {
    public Water() {
        super(new WaterBoots(), "obstacle_water");
    }
}
