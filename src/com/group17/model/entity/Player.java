/**
 * This class represents the player. It includes methods that will allow the player to pick up
 * items and use them whilst also setting the players position.
 * @author
 */
package com.group17.model.entity;

import com.group17.core.Position;
import com.group17.model.GameObject;
import com.group17.model.entity.item.Item;
import com.group17.model.entity.item.Key;

import java.util.*;

public class Player extends GameObject {
    private Position position;
    private Map inventory;

    public Player(Position position) {
        super("player");
        inventory = new HashMap();
        this.position = position;
    }
    
    /**
     * Set position of the player
     * @param position
     */

    public void setPosition(Position position){
        this.position = position;
    }
       
    /**Get the position of the player
     * @return position 
     */

    public Position getPosition() {
        return this.position;
    }
    
    /**
     * Gets the ammount of items present in the inventory or returns
     * false if item is not present in the players inventory
     * @param item is the item which is checked for
     * @return integer quantity of the items present false if none of the items are present
     */
    
    public boolean hasItem(Item item) {
        if (inventory.containsKey(item)) {
            return (int) inventory.get(item) > 0;
        }
        return false;
    }

    /**
     * Gets the amount of a type of item present if its greater than amount
     * @param item is the item which is checked for
     * @param amount is amount of the item which is checked for
     * @return integer of the quantity of items false if the number of items is below amount requested
     */
    
    public  boolean hasItem(Item item, int amount) {
        if (inventory.containsKey(item)) {
            return (int) inventory.get(item) >= amount;
        }
        return false;
    }

    /**
     * The item is inserted into the inventory
     * @param item that the player picks up
     */
    
    public void pickUp(Item item) {
        if (!inventory.containsKey(item)) {
            inventory.put(item, 1);
        } else {
            int current = (int) inventory.get(item);
            inventory.put(item, ++current);
        }
    }
    
    /**
     * Clears the inventory of any items
     */

    public void clearInventory() {
        inventory = new HashMap();
    }

    /**
     * Checks if the player has the item and takes it from the players
     * inventory if they have an item of that type
     * @param item to be used by the player
     * @return true if the player has the item and false if the player does not have the item
     */
    
    public boolean useItem(Item item) {
        if (hasItem(item)) {
            int current = (int) inventory.get(item);
            inventory.put(item, --current);
            return true;
        }
        return false;
    }

    /**
     * Checks if the player has a certain amount of an item
     * takes an amount from the player accoringly
     * @param item
     * @param amount to be used
     * @return true after taking the amount from inventory false if items are not present
 	 */
    
    public boolean useItem(Item item, int amount) {
        if (hasItem(item, amount)) {
            int current = (int) inventory.get(item);
            inventory.put(item, current-amount);
            return true;
        }
        return false;
    }

    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (Object item : inventory.keySet()) {
            int amount = (int) inventory.get(item);
            if (amount > 0) {
                items.add(item.toString() + " x" + amount);
            }
        }
        return items;
    }
}
