package game;

import java.util.Dictionary;
import java.util.Hashtable;

public class Player extends GameObject {
    private Dictionary inventory = new Hashtable();

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
    }

    public void pickUp(Item item) {
        Object inventoryItem = null;
        int amount = 0;

        if(item instanceof Key){
            inventoryItem = ((Key)item).getKeyType();
        } else if(item instanceof Boots) {
            inventoryItem = ((Boots)item).getBootType();
        } else {
            inventoryItem = item.getItemType();
        }

        if(inventory.get(inventoryItem) != null) {
            amount = (int)inventory.get(inventoryItem);
        }
        inventory.put(inventoryItem, ++amount);
    }

    public int checkInventory(Object inventoryItem) {
        int amount = 0;

        if(inventory.get(inventoryItem) != null) {
            amount = (int)inventory.get(inventoryItem);
        }

        return amount;
    }
}
