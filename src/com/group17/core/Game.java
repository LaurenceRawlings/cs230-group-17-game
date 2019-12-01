package com.group17.core;

import com.group17.model.entity.Moveable;
import com.group17.model.entity.Player;
import com.group17.model.entity.item.Key;
import com.group17.model.entity.item.Token;
import com.group17.model.world.*;

import java.io.Serializable;
import java.util.PriorityQueue;

public class Game implements Serializable {
    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

    public Game() {
        levelQueue = new PriorityQueue<>();
        levelQueue.addAll(LevelReader.readLevels());
        currentLevel = levelQueue.poll();
        assert currentLevel != null;
        player = new Player(currentLevel.getStart());
    }

    public boolean nextLevel() {
        if (levelQueue.peek() != null) {
            currentLevel = levelQueue.poll();
            return true;
        } else {
            return false;
        }
    }

    public void move(Moveable.Direction direction) {
        Position next = null;
        switch (direction) {
            case right:
                next = new Position(player.getPosition().x() + 1, player.getPosition().y());
                break;
            case left:
                next = new Position(player.getPosition().x() - 1, player.getPosition().y());
                break;
            case up:
                next = new Position(player.getPosition().x(), player.getPosition().y() - 1);
                break;
            case down:
                next = new Position(player.getPosition().x(), player.getPosition().y() + 1);
                break;
        }
        Cell nextCell = currentLevel.getCell(next);
        if(!currentLevel.getEnemy(next)){
            if (nextCell.isWalkable()) {
                if (nextCell instanceof Ground) {
                    player.setPosition(next);
                } else if (nextCell instanceof Obstacle) {
                    if (player.hasItem(((Obstacle) nextCell).getCounterItem())) {
                        player.setPosition(next);
                    } else {/*die?*/}
                }
            }
            else {
                if (nextCell instanceof Teleporter) {
                    player.setPosition(((Teleporter) nextCell).getDestination().getPosition());
                }
                if (nextCell instanceof Door) {
                    if (nextCell instanceof TokenDoor) {
                        if (player.hasItem(new Token(), ((TokenDoor) nextCell).getTokenCost())) {
                            ((TokenDoor) nextCell).open();
                            player.useItem(new Token(), ((TokenDoor) nextCell).getTokenCost());
                            player.setPosition(next);
                        }
                    }
                    if (nextCell instanceof KeyDoor) {
                        if ((player.hasItem(new Key(Key.KeyType.red))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.red)) {
                            ((KeyDoor) nextCell).open();
                            player.useItem(new Key(Key.KeyType.red));
                            player.setPosition(next);
                        }
                        if ((player.hasItem(new Key(Key.KeyType.green))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.green)) {
                            ((KeyDoor) nextCell).open();
                            player.useItem(new Key(Key.KeyType.green));
                            player.setPosition(next);
                        }
                        if ((player.hasItem(new Key(Key.KeyType.blue))) && (((KeyDoor) nextCell).getKey() == Key.KeyType.blue)) {
                            ((KeyDoor) nextCell).open();
                            player.useItem(new Key(Key.KeyType.blue));
                            player.setPosition(next);
                        }
                    }
                    }
                }
            }
        else {
            //die???????????
        }
        }

}
