/**
 * This class defines the dumb enemys movement. This class contains calculations that allows the enemy type to
 * follow the player in a basic manner.
 * @author
 */

package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;

public class DumbFollowingEnemy extends Enemy {
    private Position nextDumbPosition;
    public DumbFollowingEnemy(Position position, Direction direction, Level level, Position initialTarget) {
        super(EnemyType.dumb, position, direction, level);
        moveDumb(new Player(initialTarget));
    }

    /**
     * Method to move the enemy in the direction of the player by calculating the difference
     * in position between the enemy and the player.
     * @param player
     */
    
    @Override
    public void move(Player player) {
        move(nextDumbPosition);
        moveDumb(player);
    }

    private void moveDumb(Player player) {
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
            if(super.canMove(Position.nextPosition(position, Direction.left))){
                nextDumbPosition = Position.nextPosition(position, Direction.left);
                return true;
            }
        } else if (xDif < 0) {
            if(super.canMove(Position.nextPosition(position, Direction.right))){
                nextDumbPosition = Position.nextPosition(position, Direction.right);
                return true;
            }
        }
        return false;
    }

    private boolean moveY(int yDif) {
        if (yDif > 0) {
            if(super.canMove(Position.nextPosition(position, Direction.up))){
                nextDumbPosition = Position.nextPosition(position, Direction.up);
                return true;
            }
        } else if (yDif < 0) {
            if(super.canMove(Position.nextPosition(position, Direction.down))){
                nextDumbPosition = Position.nextPosition(position, Direction.down);
                return true;
            }
        }
        return false;
    }
}
