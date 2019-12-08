package com.group17.game.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph implements Serializable{
    private final HashMap<Node, LinkedList<Node>> adjMap;
    private final LinkedList<Node> pathList = new LinkedList<>();

    public Graph() {
        adjMap = new HashMap<>();
    }

    private void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjMap.put(a,tmp);
    }

    public void addEdge(Node source, Node destination) {
        if (!adjMap.containsKey(source))
            adjMap.put(source, null);

        if (!adjMap.containsKey(destination))
            adjMap.put(destination, null);

        addEdgeHelper(source, destination);
        addEdgeHelper(destination, source);
    }

    public LinkedList<Node> findShortestPathHelper(Node Start, Node Goal){
        if (Start != null){
            findShortestPath(Start, Goal);
            if (pathList.getLast().n != Start.n) {
                return null;
            } else {
                return pathList;
            }
        } else{
            return null;
        }
    }

    private void findShortestPath(Node Start, Node Goal) {
        if (Start != null){
            pathList.add(Goal);
            while (!Goal.prevVisited && !Goal.n.equals(Start.n)){
                Goal.prevVisited = true;
                if (Goal.prev != null) {
                    findShortestPath(Start, Goal.prev);
                }
            }
        }
    }

    public void breadthFirstSearch(Node node) {
        if (node == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            if (currentFirst.isVisited())
                continue;

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
    }

}

