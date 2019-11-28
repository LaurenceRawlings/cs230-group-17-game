package com.group17.model.entity.enemy;

import com.group17.core.Position;

public class DumbFollowingEnemy extends Enemy {
    public DumbFollowingEnemy(Position position, Direction direction) {
        super(position, direction);
    }

    @Override
    public void move(Direction direction) {

    }
}
