package com.group17.core;

import com.group17.model.entity.Player;
import com.group17.model.entity.item.Key;
import com.group17.model.entity.item.Token;

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
}

