package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

public class WallFollowingEnemy extends Enemy {
    private boolean reachedWall;

    public WallFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.wall, position, direction, level);
        reachedWall = false;
    }

    @Override
    public void move(Player player) {
        if (reachedWall) {
            if (!move(Position.nextPosition(position, Direction.right.relative(direction)))) {
                if (!move(Position.nextPosition(position, Direction.up.relative(direction)))) {
                    direction = direction.rotateRight().flip();
                    if (!move(Position.nextPosition(position, Direction.up.relative(direction)))) {
                        direction = direction.rotateRight().flip();
                        move(Position.nextPosition(position, Direction.up.relative(direction)));
                    }
                }
            } else {
                direction = direction.rotateRight();
            }
        } else {
            if (!move(Position.nextPosition(position, Direction.right.relative(direction)))) {
                reachedWall = true;
                move(player);
            }
        }
    }
}
