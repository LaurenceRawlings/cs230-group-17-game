public class Obstacle extends Cell {
    public enum ObstacleType {
        fire,
        water
    }

    private ObstacleType obstcleType;
    private Item.ItemType counterItem;

    public Obstacle(int xPos, int yPos, ObstacleType obstacleType) {
        super(xPos, yPos, true);
        this.obstcleType = obstacleType;
    }
}
