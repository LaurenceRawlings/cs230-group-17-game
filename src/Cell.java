public abstract class Cell extends GameObject {
    private boolean walkable;

    public Cell(Position position, boolean walkable) {
        super(position);
        this.walkable = walkable;
    }
}
