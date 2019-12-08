/**
 * Class defining the level setup overall. Contains getters and setters for items and cells.
 * Also contains methods to update enemy positions.
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.core.Position;
import com.group17.game.model.entity.Player;
import com.group17.game.model.entity.enemy.Enemy;
import com.group17.game.model.entity.item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Level implements Comparable<Level>, Serializable, Cloneable {
    private final Cell[][] cells;
    private final Item[][] items;
    private Enemy.EnemyType[][] enemyPositions;
    private final List<Enemy> enemies;
    private final int levelNumber;
    private final String levelName;
    private final Position start;
    private final Position finish;
    private final int width;
    private final int height;
    private int time;
    
    /** Method gets the time
     * @return time
     */

    public int getTime() {
        return time;
    }
    
    /**
     * Method sets the time
     * @param time
     */

    public void setTime(int time) {
        this.time = time;
    }
    
    /**
     * Method returns the name of a level
     * @return levelName
     */

    @Override
    public String toString() {
        return levelName;
    }
    
    /**
     * Method gets the starting position for the player
     * @return start
     */

    public Position getStart() {
        return start;
    }
    
    /**
     * Method gets the finishing position for the player
     * @return finish
     */

    public Position getFinish() {
        return finish;
    }

    /**
     * Method to get the width of the level
     * @return width
     */
    
    public int getWidth() {
        return width;
    }
    
    /**
     * Method to get the height of the level
     * @return height
     */

    public int getHeight() {
        return height;
    }

    /**
     * Method sets multiple aspects of the level including height and width
     * of cells, items and enemy positions
     * @param start
     * @param finish
     * @param levelNumber
     * @param levelName
     * @param width
     * @param height
     */    
    
    public Level(Position start, Position finish, int levelNumber, String levelName, int width, int height) {
        this.levelNumber = levelNumber;
        this.levelName = levelName;
        this.start = start;
        this.finish = finish;
        this.width = width;
        this.height = height;

        cells = new Cell[height][width];
        items = new Item[height][width];
        enemyPositions = new Enemy.EnemyType[height][width];
        enemies = new ArrayList<>();
    }
    
    /**
     * Method to get the number of a level
     * @return levelNumber
     */

    private int getLevelNumber() {
        return levelNumber;
    }
    
    /**
     * Method to set the position of a cell
     * @param position
     * @param cell
     */

    public void setCell(Position position, Cell cell) {
        cells[position.y()][position.x()] = cell;
    }
    
    /**
     * Method to set an items position
     * @param position
     * @param item
     */

    public void setItem(Position position, Item item) {
        items[position.y()][position.x()] = item;
    }
    
    /**
     * Method to get a cells position
     * @param position
     * @return x and y coordinates of the cells position
     */

    public Cell getCell(Position position) {
        return cells[position.y()][position.x()];
    }
    
    /**
     * Method to get an items position
     * @param position
     * @return x and y coordinates of the items position
     */

    public Item getItem(Position position) {
        return items[position.y()][position.x()];
    }

    @Override
    public int compareTo(Level level) {
        return Integer.compare(levelNumber, level.getLevelNumber());
    }
    
    /**
     * Method to add an enemy to the enemies array
     * @param enemy
     */

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    /**
     * Method to update enemy coordinate positions for every enemy in the enemies array
     */
    
    public void updateEnemyPositions() {
        enemyPositions = new Enemy.EnemyType[height][width];
        for (Enemy enemy : enemies) {
            enemyPositions[enemy.getPosition().y()][enemy.getPosition().x()] = enemy.getEnemyType();
        }
    }
    
    /**
     * Method to move the enemies for every enemy in the enemies array
     * @param player
     */
    
    public void moveEnemies(Player player) {
        for (Enemy enemy : enemies) {
            enemy.move(player);
            updateEnemyPositions();
        }
    }
    
    /**
     * Method to get an enemies position
     * @param position
     * @return x and y coordinate of an enemy
     */

    public Enemy.EnemyType getEnemy(Position position){
        return enemyPositions[position.y()][position.x()];
    }

}
