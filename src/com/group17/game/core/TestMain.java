package com.group17.game.core;

import java.util.Arrays;

import java.util.LinkedList;

public class TestMain {
    public static void main(String[] args) {
        Profile p1 = new Profile("Top");
        Profile p2 = new Profile("Middle");
        Profile p3 = new Profile("Bottom");

        p1.setLevelTime("Level 2", 1);
        p2.setLevelTime("Level 2", 4);
        p3.setLevelTime("Level 2", 3);

        ProfileManager.save(p1);
        ProfileManager.save(p2);
        ProfileManager.save(p3);

//        System.out.println(Arrays.toString(Leaderboard.getTopTimes("Level 2", 5)));

        System.out.println(Leaderboard.formatTime(100000));
        System.out.println((int) Double.POSITIVE_INFINITY);
    }

    public static void main2(String[] args) throws InterruptedException {

        Graph graph = new Graph();
        Node[][] nodeMap = new Node[5][5];
        nodeMap[0][0] = new Node(new Position(1,1));
        nodeMap[0][1] = new Node(new Position(2,1));
        nodeMap[0][2] = new Node(new Position(2,3));
        nodeMap[0][3] = new Node(new Position(2,4));
        nodeMap[0][4] = new Node(new Position(3,5));

        graph.addEdge(nodeMap[0][4], nodeMap[0][2]);
        graph.addEdge(nodeMap[0][3], nodeMap[0][2]);
        graph.addEdge(nodeMap[0][3], nodeMap[0][1]);
        graph.addEdge(nodeMap[0][2], nodeMap[0][1]);
        graph.addEdge(nodeMap[0][1], nodeMap[0][0]);

        graph.breadthFirstSearch(nodeMap[0][0]);
        LinkedList shortestPath = graph.findShortestPathHelper(nodeMap[0][0], nodeMap[0][4]);
        if (shortestPath == null){
            System.out.println("Failed to find node path");
        } else {
            System.out.println(Arrays.toString(shortestPath.toArray()));

        }
    }
}

