package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;

public class SmartFollowingEnemy extends Enemy {
    public SmartFollowingEnemy(Position position, Direction direction) {
        super(EnemyType.smart, position, direction);
    }

}

