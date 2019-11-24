package com.group17.model;

public class Obstacle extends Cell {
    public enum ObstacleType {
        fire,
        water
    }

    private ObstacleType obstacleType;
    private Item.ItemType counterItem;

    public Obstacle(Position position, ObstacleType obstacleType) {
        super(position, true);
        this.obstacleType = obstacleType;
    }
}
