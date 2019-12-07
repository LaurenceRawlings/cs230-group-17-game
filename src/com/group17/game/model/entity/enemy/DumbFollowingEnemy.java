package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

public class DumbFollowingEnemy extends Enemy {
    public DumbFollowingEnemy(Position position, Direction direction, Level level) {
        super(EnemyType.dumb, position, direction, level);
    }

    @Override
    public void move(Player player) {
        int xDif = (position.x() - player.getPosition().x());
        int yDif = (position.y() - player.getPosition().y());

        if (Math.abs(xDif) >= Math.abs(yDif)) {
            if (!moveX(xDif)) {
                moveY(yDif);
            }
        } else{
            if (!moveY(yDif)) {
                moveX(xDif);
            }
        }

    }

    private boolean moveX(int xDif) {
        if (xDif > 0) {
            return move(Position.nextPosition(position, Direction.left));
        } else if (xDif < 0) {
            return move(Position.nextPosition(position, Direction.right));
        }

        return false;
    }

    private boolean moveY(int yDif) {
        if (yDif > 0) {
            return move(Position.nextPosition(position, Direction.up));
        } else if (yDif < 0) {
            return move(Position.nextPosition(position, Direction.down));
        }

        return false;
    }
}
