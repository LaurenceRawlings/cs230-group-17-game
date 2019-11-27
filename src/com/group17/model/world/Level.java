package com.group17.model.world;

import com.group17.core.Position;
import com.group17.model.entity.enemy.Enemy;
import com.group17.model.entity.item.Item;

public class Level implements Comparable<Level> {
    private Position playerPosition;
    private Cell[][] cells;
    private Item[][] items;
    private Enemy[][] enemies;
    private int levelNumber;
    private String levelName;

    public Level(Position playerStart, int levelNumber, String levelName,
                 int width, int height, int tokens) {
        this.playerPosition = playerStart;
        this.levelNumber = levelNumber;
        this.levelName = levelName;

        cells = new Cell[height][width];
        items = new Item[height][width];
        enemies = new Enemy[height][width];
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setCell(Position position, Cell cell) {
        addToGame(cells, position, cell);
    }

    public void setItem(Position position, Item item) {
        addToGame(items, position, item);
    }

    public void setEnemy(Position position, Enemy enemy) {
        addToGame(enemies, position, enemy);
    }

    public Cell getCell(Position position) {
        return cells[position.y()][position.x()];
    }

    public Item getItem(Position position) {
        return items[position.y()][position.x()];
    }

    public Enemy getEnemy(Position position) {
        return enemies[position.y()][position.x()];
    }

    private <T> T[][] addToGame(T[][] matrix, Position position, T object) {
        matrix[position.y()][position.x()] = object;
        return matrix;
    }

    @Override
    public int compareTo(Level level) {
        if (levelNumber == level.getLevelNumber()) {
            return 0;
        } else if (levelNumber > level.getLevelNumber()) {
            return 1;
        } else {
            return -1;
        }
    }
}
