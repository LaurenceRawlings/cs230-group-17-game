package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;

public class DumbFollowingEnemy extends Enemy {
    public DumbFollowingEnemy(Position position, Direction direction) {
        super(EnemyType.dumb, position, direction);
    }

}
