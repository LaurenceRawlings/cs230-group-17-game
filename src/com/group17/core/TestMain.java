package com.group17.core;

import com.group17.model.entity.item.FireBoots;
import com.group17.model.entity.item.Item;
import com.group17.model.entity.item.Key;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(MOTD.get());

        Profile p = new Profile("Laurence");
        p.newGame();
        p.setHighscore(1000);
        ProfileManager.save(p);

        Profile p2 = new Profile("Fraz");
        p2.newGame();
        p2.setHighscore(800);
        ProfileManager.save(p2);

        Profile p3 = new Profile("Bias");
        p3.newGame();
        p3.setHighscore(900);
        ProfileManager.save(p3);

        Profile p4 = new Profile("Sam");
        p4.newGame();
        p4.setHighscore(500);
        ProfileManager.save(p4);



        System.out.println(ProfileManager.getProfileNames());



        for (Profile profile : ProfileManager.getProfiles()) {
            System.out.println(profile.getName());
        }
    }
}
