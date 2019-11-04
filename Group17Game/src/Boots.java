public class Boots extends Item {
    public enum BootType{
        fire,
        water
    }

    private BootType bootType;

    public Boots(BootType bootType, int xPos, int yPos) {
        super(ItemType.boots, xPos, yPos);
        this.bootType = bootType;
    }
}
