package com.group17.core;

import com.group17.model.entity.Player;
import com.group17.model.entity.item.Key;
import com.group17.model.entity.item.Token;

import java.util.Arrays;
import java.util.LinkedList;

public class TestMain {
    public static void main(String[] args) {
        Player p = new Player(new Position(1,1));
        Key k1 = new Key(Key.KeyType.red);
        Key k2 = new Key(Key.KeyType.blue);
        Token t = new Token();

        p.pickUp(k1);
        p.pickUp(t);
        System.out.println(p.hasItem(new Key(Key.KeyType.red)));
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

