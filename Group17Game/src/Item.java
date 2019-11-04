public class Item extends GameObject {
    public enum ItemType{
        key,
        token,
        boots
    }

    private ItemType itemType;

    public Item(ItemType itemType, int xPos, int yPos) throws Exception {
        super(xPos, yPos);

        if(itemType == ItemType.key || itemType == ItemType.boots) {
            throw new Exception("Instantiate specific object to create an item of this type.");
        }

        this.itemType = itemType;
    }
}
