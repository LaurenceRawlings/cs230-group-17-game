package com.group17.game.core;

import java.io.Serializable;

public class Node implements Serializable {
    final Position n;
    private boolean visited;
    Node prev;
    boolean prevVisited;

    public Node(Position n) {
        this.n = n;
        visited = false;
        prevVisited = false;
    }

    public Position getPos(){
        return this.n;
    }

    void visit() {
        visited = true;
    }

    void setPrev(Node prev){
        this.prev = prev;
    }

    public boolean isVisited() {
        return this.visited;
    }

    @Override
    public String toString(){
        return "Node (" + n.x() + " " + n.y() + ")";
    }
}
