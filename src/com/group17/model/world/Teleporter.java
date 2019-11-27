package com.group17.model.world;

import com.group17.core.Position;

public class Teleporter extends Cell {
    private Teleporter destination;
    private Position position;

    public Teleporter(Position position, Position destinationPosition) {
        super(true);
        this.position = position;
        destination = new Teleporter(destinationPosition, position);
    }

    public Position getPosition() {
        return position;
    }

    public Position getDestination() {
        return destination.getPosition();
    }
}
