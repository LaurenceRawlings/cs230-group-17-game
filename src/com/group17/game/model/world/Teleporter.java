package com.group17.game.model.world;

import com.group17.game.core.Position;

public class Teleporter extends Cell {
    private final Teleporter destination;
    private final Position position;

    public Teleporter(Position position, Position destinationPosition) {
        super(true, "Teleporter");
        this.position = position;
        destination = new Teleporter(destinationPosition, this);
    }

    private Teleporter(Position position, Teleporter destination) {
        super(true, "Teleporter");
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
