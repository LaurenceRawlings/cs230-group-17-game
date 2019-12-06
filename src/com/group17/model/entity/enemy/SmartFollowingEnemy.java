package com.group17.model.entity.enemy;

import com.group17.core.Position;
import com.group17.model.entity.Direction;

public class SmartFollowingEnemy extends Enemy {
    public SmartFollowingEnemy(Position position, Direction direction) {
        super(EnemyType.smart, position, direction);
    }

}
