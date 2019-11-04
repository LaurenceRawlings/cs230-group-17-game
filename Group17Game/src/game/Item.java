package game;

public class Item extends GameObject {
    public enum ItemType{
        key,
        token,
        boots
    }

    private ItemType itemType;

    public Item(ItemType itemType, int xPos, int yPos) {
        super(xPos, yPos);
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
