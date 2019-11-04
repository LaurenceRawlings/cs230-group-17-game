package game;

public class Boots extends Item {
    public enum BootType{
        fire,
        water
    }

    private BootType bootType;

    public Boots(BootType bootType, int xPos, int yPos) throws Exception {
        super(ItemType.boots, xPos, yPos);
        this.bootType = bootType;
    }

    public BootType getBootType() {
        return bootType;
    }
}
