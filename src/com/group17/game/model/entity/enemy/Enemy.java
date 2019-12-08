/**
 * This class is the father class for all enemy types. Icludes elements common to all enemy types
 * including an enemys ability to rotate and move position.
 * @author
 */
package com.group17.game.model.entity.enemy;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Ground;
import com.group17.game.model.world.Level;

import java.io.Serializable;

public abstract class Enemy implements Serializable {
    public abstract void move(Player player);

    public enum EnemyType {
        smart("enemy_smart"),
        dumb("enemy_dumb"),
        wall("enemy_wall"),
        line("enemy_line");

        private final String spriteName;

        EnemyType(String label) {
            this.spriteName = label;
        }

        public String getSpriteName() {
            return spriteName;
        }
    }

    Position position;
    Direction direction;
    private final EnemyType enemyType;
    final Level level;
    
    /**
     * Method to set an enemys position, direction, enum and level
     * @param enemType
     * @param position
     * @param direction
     * @param level
     */

    Enemy(EnemyType enemyType, Position position, Direction direction, Level level) {
        this.position = position;
        this.direction = direction;
        this.enemyType = enemyType;
        this.level = level;
    }

    boolean move(Position nextPosition) {
        if (canMove(nextPosition)) {
            position = nextPosition;
            return true;
        } else {
            return false;
        }
    }

    boolean canMove(Position nextPosition){
        return level.getCell(nextPosition) instanceof Ground;
    }
    
    /**
     * Method to get the current position of an enemy
     * @return position
     */

    public Position getPosition() {
        return position;
    }
    
    /**
     * Method to get the enemy type
     * @return enemyType
     */

    public EnemyType getEnemyType() {
        return enemyType;
    }
}
