package com.group17.game.model.world;

import com.group17.game.core.Position;
import com.group17.game.model.entity.enemy.Enemy;
import com.group17.game.model.entity.item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Level implements Comparable<Level>, Serializable {
    private Cell[][] cells;
    private Item[][] items;
    private Enemy.EnemyType[][] enemyPositions;
    private List<Enemy> enemies;
    private int levelNumber;
    private String levelName;
    private Position start;
    private Position finish;
    private int width;
    private int height;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return levelName;
    }

    public Position getStart() {
        return start;
    }

    public Position getFinish() {
        return finish;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

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

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setCell(Position position, Cell cell) {
        cells[position.y()][position.x()] = cell;
    }

    public void setItem(Position position, Item item) {
        items[position.y()][position.x()] = item;
    }

    public Cell getCell(Position position) {
        return cells[position.y()][position.x()];
    }

    public Item getItem(Position position) {
        return items[position.y()][position.x()];
    }

    @Override
    public int compareTo(Level level) {
        return Integer.compare(levelNumber, level.getLevelNumber());
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        updateEnemyPositions();
    }

    public void updateEnemyPositions() {
        enemyPositions = new Enemy.EnemyType[height][width];
        for (Enemy enemy : enemies) {
            enemyPositions[enemy.getPosition().y()][enemy.getPosition().x()] = enemy.getEnemyType();
        }
    }

    public Enemy.EnemyType getEnemy(Position position){
        return enemyPositions[position.y()][position.x()];
    }

    public List<Enemy> getEnemies(){return enemies;}
}
