package com.group17.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph implements Serializable{

    // Each node maps to a list of all his neighbors
    private HashMap<Node, LinkedList<Node>> adjMap;
    public LinkedList<Node> pathList = new LinkedList<>();

    public Graph() {
        adjMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjMap.put(a,tmp);
    }

    public void addEdge(Node source, Node destination) {

        // We make sure that every used node shows up
        if (!adjMap.containsKey(source))
            adjMap.put(source, null);

        if (!adjMap.containsKey(destination))
            adjMap.put(destination, null);

        addEdgeHelper(source, destination);
        addEdgeHelper(destination, source);
    }

    LinkedList<Node> findShortestPathHelper(Node Start, Node Goal){
        Node finalGoal = findShortestPath(Start, Goal);
        if (pathList.getLast().n != Start.n){
            return null;
        } else {
            return pathList;
        }
    }

    Node findShortestPath(Node Start, Node Goal) {
        pathList.add(Goal);
        //Thread.sleep(400);
        while (!Goal.prevVisited && !Goal.n.equals(Start.n)){
            Goal.prevVisited = true;
            if (Goal.prev != null) {
                findShortestPath(Start, Goal.prev);
            }
        }
        return Goal;
    }

    public boolean hasEdge(Node source, Node destination) {
        return adjMap.containsKey(source) && adjMap.get(source).contains(destination);
    }

    void breadthFirstSearch(Node node) {
        if (node == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            // Skip the node if we already visited it
            if (currentFirst.isVisited())
                continue;

            // Mark the node as visited
            currentFirst.visit();

            LinkedList<Node> allNeighbors = adjMap.get(currentFirst);

            if (allNeighbors == null)
                continue;

            for (Node neighbor : allNeighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setPrev(currentFirst);
                }
            }
        }
        System.out.println();
    }

}

