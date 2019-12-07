package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

public class LineFollowingEnemy extends Enemy {
    public LineFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.line, position, direction, level);
    }

    @Override
    public void move(Player player) {
        if (!move(Position.nextPosition(position, direction))) {
            direction = direction.flip();
            move(Position.nextPosition(position, direction));
        }
    }
}
