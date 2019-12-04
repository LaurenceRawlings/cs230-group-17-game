package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Direction;

public class DumbFollowingEnemy extends Enemy {
    public DumbFollowingEnemy(Position position, Direction direction) {
        super(position, direction, "enemy_dumb");
    }

}
