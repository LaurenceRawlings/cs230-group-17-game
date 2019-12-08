/**
 * This class is the manager for the game. It allows the levels to change and update the positions
 * of entities as well as defines where entities can and cannot move.
 * @author
 */
package com.group17.game.core;

import com.group17.game.controller.MessageController;
import com.group17.game.controller.SceneController;
import com.group17.game.model.entity.Direction;
import com.group17.game.model.entity.Player;
import com.group17.game.model.entity.item.Item;
import com.group17.game.model.entity.item.Key;
import com.group17.game.model.entity.item.Token;
import com.group17.game.model.world.*;

import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {
    private List<Level> levelQueue;
    private Level currentLevel;
    private int levelIndex;
    private Player player;
    private int fov;

    public int getFov() {
        return fov;
    }
    public void setFov(int fov) {
        this.fov = fov;
    }

    /**
     * Method to get the current level
     * @return currentLevel
     */
    
    public Level getCurrentLevel() {
        return currentLevel;
    }
    
    /**
     * Method to get the player
     * @return player 
     */
    
    public Player getPlayer() {
        return player;
    }


    public Game() {
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(0);
        currentLevel.updateEnemyPositions();
        levelIndex = 0;
        player = new Player(currentLevel.getStart());
        fov = 3;
    }
    
    /**
     * Method to set the current level based on the level index and update the enemy positions
     * @param levelIndex
     */

    public Game(int levelIndex) {
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(levelIndex);
        currentLevel.updateEnemyPositions();
        this.levelIndex = levelIndex;
        player = new Player(currentLevel.getStart());
        fov = 3;
    }
    
    /**
     * Method to get the index of the current level
     * @return levelIndex
     */

    public int getLevelIndex() {
        return levelIndex;
    }
    
    /**
     * Method sets the current level to the next indexed level
     * @return true if next level is present false if not
     */

    public boolean nextLevel() {
        try {
            currentLevel = levelQueue.get(++levelIndex);
            currentLevel.updateEnemyPositions();
            player = new Player(currentLevel.getStart());
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    
    /**
     * Method to update the positions of entities. Establishes laws concerning item pickup,
     * teleportation and enemy contact with the player.
     * @param direction
     */

    public void move(Direction direction) {
        Position next = Position.nextPosition(player.getPosition(), direction);

        if (canMove(next)) {
            player.setPosition(next);
            Position current = player.getPosition();
            Item item = currentLevel.getItem(current);
            Cell cell = currentLevel.getCell(current);
            if (item != null) {
                player.pickUp(item);
                currentLevel.setItem(current, null);
            }
            if (cell instanceof Teleporter) {
                player.setPosition(((Teleporter) currentLevel.getCell(current)).getDestination().getPosition());
                move(direction);
            }
            currentLevel.moveEnemies(player);
            if (currentLevel.getEnemy(current) != null) {
                die();
            }
        }
    }

    private boolean canMove(Position nextPosition) {
        Cell cell = currentLevel.getCell(nextPosition);
        if (cell.isWalkable()) {
            if (currentLevel.getEnemy(nextPosition) != null) {
                player.setPosition(nextPosition);
                die();
                return false;
            }
            return true;
        } else {
            if (cell instanceof KeyDoor) {
                Key key = new Key(((KeyDoor) cell).getKey());
                if (player.hasItem(key)) {
                    currentLevel.setCell(nextPosition, new Ground());
                    player.useItem(key);
                    return true;
                }
            } else if (cell instanceof TokenDoor) {
                Token token = new Token();
                int cost = ((TokenDoor) cell).getTokenCost();
                if (player.hasItem(token, cost)) {
                    currentLevel.setCell(nextPosition, new Ground());
                    return true;
                }
            } else if (cell instanceof Obstacle) {
                return player.hasItem(((Obstacle) cell).getCounterItem());
            }

        }
        return false;
    }

    private void die() {
        MessageController.showMessage(SceneController.getLanguageBundle().getString("msg_die_title"), SceneController.getLanguageBundle().getString("msg_die_head"), SceneController.getLanguageBundle().getString("msg_die_body"));
        levelQueue = LevelReader.getLevelQueue();
        currentLevel = levelQueue.get(levelIndex);
        currentLevel.updateEnemyPositions();
        player = new Player(currentLevel.getStart());
    }
}
