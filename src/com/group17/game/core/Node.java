/**
 * Class defines node necessary for the graph used sprite movement
 * @author
 */
package com.group17.game.core;

import java.io.Serializable;

public class Node implements Serializable {
    final Position n;
    private boolean visited;
    Node prev;
    boolean prevVisited;

    /**
	 * Method to set a node. Node is not visited and has no previously visited nodes.
	 * @param n
	 */
    
    public Node(Position n) {
        this.n = n;
        visited = false;
        prevVisited = false;
    }
    
    /**
	 * Method to get the position of a node
	 * @return n the current objects position
	 */

    public Position getPos(){
        return this.n;
    }

    void visit() {
        visited = true;
    }

    void setPrev(Node prev){
        this.prev = prev;
    }

    /**
	 * Method to determine whether a node is visited or not.
	 * @return visited true or false based on if the current node is visited or not
	 */
    
    public boolean isVisited() {
        return this.visited;
    }
    
    /**
	 * Method returns a string representing the x and y coordinates of a node
	 * @return a string containing x and y
	 */

    @Override
    public String toString(){
        return "Node (" + n.x() + " " + n.y() + ")";
    }
}
