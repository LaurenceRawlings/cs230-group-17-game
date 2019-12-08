/**
 * Class representing a teleporter
 * @author
 */

package com.group17.game.model.world;

import com.group17.game.core.Position;

public class Teleporter extends Cell {
    private final Teleporter destination;
    private final Position position;
    
    /**
     * Method sets the position and a new destination for where the player will be taken
     * @param position
     * @param destinationPosition
     */

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

    /**
     * Method gets the position of a teleporter
     * @return position
     */
    
    public Position getPosition() {
        return position;
    }
    
    /**
     * Method gets the destination of a teleporter
     * @return destination
     */

    public Teleporter getDestination() {
        return destination;
    }
}
