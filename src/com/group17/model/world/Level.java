package com.group17.model.world;

import com.group17.core.Position;
import com.group17.model.entity.enemy.Enemy;
import com.group17.model.entity.item.Item;

public class Level implements Comparable<Level> {
    private Cell[][] cells;
    private Item[][] items;
    private int levelNumber;
    private String levelName;

    public Level(Position start, int levelNumber, String levelName,
                 int width, int height) {
        this.levelNumber = levelNumber;
        this.levelName = levelName;

        cells = new Cell[height][width];
        items = new Item[height][width];
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
        if (levelNumber == level.getLevelNumber()) {
            return 0;
        } else if (levelNumber > level.getLevelNumber()) {
            return 1;
        } else {
            return -1;
        }
    }
}
