package com.group17.core;

import com.group17.model.entity.item.FireBoots;
import com.group17.model.entity.item.Item;
import com.group17.model.entity.item.Key;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        FireBoots fb = new FireBoots();
        FireBoots fb2 = new FireBoots();

        System.out.println(fb.equals(fb2));

        List<Item> i = new ArrayList<>();
        i.add(fb);
        System.out.println(i.contains(fb2));

        Key k = new Key(Key.KeyType.blue);
        System.out.println(k.toString());

        Profile p = new Profile("Laurence");
        p.newGame();
        p.setHighscore(100);
        ProfileManager.save(p);

        Profile loaded = ProfileManager.load("Laurence");
        System.out.println(loaded.getName());
        System.out.println(loaded.getHighscore());


        System.out.println(ProfileManager.getProfileNames());
        System.out.println(ProfileManager.exists("Laurence.1.2.3"));
    }
}
