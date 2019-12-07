package com.group17.game.core;

import java.io.Serializable;

public class Node implements Serializable {
    Position n;
    boolean visited;
    Node prev;
    boolean prevVisited;

    public Node(Position n) {
        this.n = n;
        visited = false;
        Node prev = null;
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
        if (this.visited){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "Node (" + n.x() + " " + n.y() + ")";
    }
}