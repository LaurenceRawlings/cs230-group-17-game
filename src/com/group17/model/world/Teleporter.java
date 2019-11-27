package com.group17.model.world;

import com.group17.core.Position;

public class Teleporter extends Cell {
    private Teleporter destination;
    private Position position;

    public Teleporter(Position position, Position destinationPosition) {
        super(true);
        this.position = position;
        destination = new Teleporter(destinationPosition, this);
    }

    public Teleporter(Position position, Teleporter destination) {
        super(true);
        this.position = position;
        this.destination = destination;
    }

    public Position getPosition() {
        return position;
    }

    public Teleporter getDestination() {
        return destination;
    }
}
