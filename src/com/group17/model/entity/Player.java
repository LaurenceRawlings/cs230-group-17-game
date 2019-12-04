package com.group17.model.entity;

import com.group17.core.Position;
import com.group17.model.GameObject;
import com.group17.model.entity.item.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends GameObject {
    private Position position;
    private Map inventory;

    public Player(Position position) {
        super("player");
        inventory = new HashMap();
        this.position = position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean hasItem(Item item) {
        if (inventory.containsKey(item)) {
            if ((int) inventory.get(item) > 0) {
                return true;
            }
        }
        return false;
    }

    public  boolean hasItem(Item item, int amount) {
        if (inventory.containsKey(item)) {
            if ((int) inventory.get(item) >= amount) {
                return true;
            }
        }
        return false;
    }

    public void pickUp(Item item) {
        if (!inventory.containsKey(item)) {
            inventory.put(item, 1);
        } else {
            int current = (int) inventory.get(item);
            inventory.put(item, ++current);
        }
    }

    public void clearInventory() {
        inventory = new HashMap();
    }

    public boolean useItem(Item item) {
        if (hasItem(item)) {
            int current = (int) inventory.get(item);
            inventory.put(item, --current);
            return true;
        }
        return false;
    }

    public boolean useItem(Item item, int amount) {
        if (hasItem(item, amount)) {
            int current = (int) inventory.get(item);
            inventory.put(item, current-amount);
            return true;
        }
        return false;
    }
}
