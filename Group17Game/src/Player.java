import java.util.Dictionary;
import java.util.Hashtable;

public class Player extends GameObject {
    private Dictionary inventory = new Hashtable();

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
    }

    public void pickUp(Item item) {
        Object inventoryItem = null;
        int addAmount = 1;
        int currentAmount = 0;

        switch (item.getItemType()){
            case key:
                inventoryItem = ((Key)item).getKeyType();
                break;
            case boots:
                inventoryItem = ((Boots)item).getBootType();
                break;
            case token:
                inventoryItem = Item.ItemType.token;
                addAmount = ((Token)item).getTokenValue();
                break;
            default:
                inventoryItem = item.getItemType();
                break;
        }

        if(inventory.get(inventoryItem) != null) {
            currentAmount = (int)inventory.get(inventoryItem);
        }
        inventory.put(inventoryItem, currentAmount + addAmount);
    }

    public boolean checkKey(Key.KeyType keyType) {
        if(inventory.get(keyType) != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkBoots(Boots.BootType bootType) {
        if(inventory.get(bootType) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void useKey(Key.KeyType keyType) {
        int keyCount = 0;
        if(inventory.get(keyType) != null) {
            keyCount = (int)inventory.get(keyType);
        }
    }
}
