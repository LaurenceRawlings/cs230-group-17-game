/**
 * Class defining the wall following enemys movement.
 * @author
 */

package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

import java.util.Objects;

public class WallFollowingEnemy extends Enemy {
    private boolean reachedWall;

    public WallFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.wall, position, direction, level);
        reachedWall = false;
    }
    
    /**
     * Method for the movement of the enemy relative to a wall
     * @param player
     */

    @Override
    public void move(Player player) {
        if (reachedWall) {
            if (!move(Position.nextPosition(position, Objects.requireNonNull(Direction.right.relative(direction))))) {
                if (!move(Position.nextPosition(position, Objects.requireNonNull(Direction.up.relative(direction))))) {
                    direction = Objects.requireNonNull(direction.rotateRight()).flip();
                    if (!move(Position.nextPosition(position, Objects.requireNonNull(Direction.up.relative(Objects.requireNonNull(direction)))))) {
                        direction = Objects.requireNonNull(direction.rotateRight()).flip();
                        move(Position.nextPosition(position, Objects.requireNonNull(Direction.up.relative(Objects.requireNonNull(direction)))));
                    }
                }
            } else {
                direction = direction.rotateRight();
            }
        } else {
            if (!move(Position.nextPosition(position, Objects.requireNonNull(Direction.right.relative(direction))))) {
                reachedWall = true;
                move(player);
            }
        }
    }
}
