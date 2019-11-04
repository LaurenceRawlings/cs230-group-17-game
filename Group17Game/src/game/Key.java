package game;

public class Key extends Item {
    public enum KeyType{
        red,
        green,
        blue
    }

    private KeyType keyType;

    public Key(KeyType keyType, int xPos, int yPos) throws Exception {
        super(ItemType.key, xPos, yPos);
        this.keyType = keyType;
    }
}
