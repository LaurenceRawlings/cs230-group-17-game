public abstract class Cell extends GameObject {
    private boolean walkable;

    public Cell(int xPos, int yPos, boolean walkable) {
        super(xPos, yPos);
        this.walkable = walkable;
    }
}
