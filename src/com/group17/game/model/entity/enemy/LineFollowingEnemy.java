/**
 * Class defining the line following enemys movement.
 */
package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

import java.util.Objects;

public class LineFollowingEnemy extends Enemy {
    public LineFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.line, position, direction, level);
    }
    
    /**
     * Moves the enemy to the next cell is a given direction
     * @param player
     */

    @Override
    public void move(Player player) {
        if (!move(Position.nextPosition(position, direction))) {
            direction = direction.flip();
            move(Position.nextPosition(position, Objects.requireNonNull(direction)));
        }
    }
}
