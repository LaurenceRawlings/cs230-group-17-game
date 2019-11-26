package com.group17.model.world;

import com.group17.core.Position;
import com.group17.model.entity.Boots;
import com.group17.model.entity.Item;

public class Obstacle extends Cell {
    public enum ObstacleType {
        fire,
        water
    }

    private ObstacleType obstacleType;
    private Boots.BootType counterBoots;

    public Obstacle(Position position, ObstacleType obstacleType, Boots.BootType counterBoots) {
        super(position, true);
        this.obstacleType = obstacleType;
        this.counterBoots = counterBoots;
    }

    public Boots.BootType getCounterBoots() {
        return counterBoots;
    }
}
