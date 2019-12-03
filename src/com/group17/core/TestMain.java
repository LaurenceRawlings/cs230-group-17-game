package com.group17.core;

import com.group17.model.entity.Player;
import com.group17.model.entity.item.Token;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(MOTD.get());

        Player p = new Player(new Position(0,0));
        Token t = new Token();

        new Game();
        p.pickUp(t);
        p.pickUp(t);
        System.out.println(p.hasItem(t, 2));

        p.useItem(t, 2);

        System.out.println(p.hasItem(t, 1));
    }
}

