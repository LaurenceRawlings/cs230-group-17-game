package com.group17.game;

import com.group17.game.core.Profile;
import com.group17.game.core.ProfileManager;

public class Debug {
    public static void main(String[] args) {
        //Create Master Profiles
        Profile laurence = new Profile("Laurence");
        Profile vlad = new Profile("Vlad");
        Profile hadi = new Profile("Hadi");
        Profile tom = new Profile("Tom");
        Profile sam = new Profile("Sam");
        Profile oscar = new Profile("Oscar");

        laurence.setHighestLevel(4);
        vlad.setHighestLevel(4);
        hadi.setHighestLevel(4);
        tom.setHighestLevel(4);
        sam.setHighestLevel(4);
        oscar.setHighestLevel(4);

        laurence.setLevelTime("Level 1", 60);
        vlad.setLevelTime("Level 1", 65);
        hadi.setLevelTime("Level 1", 70);
        tom.setLevelTime("Level 1", 75);
        sam.setLevelTime("Level 1", 80);
        oscar.setLevelTime("Level 1", 85);

        laurence.setLevelTime("Level 2", 60);
        vlad.setLevelTime("Level 2", 65);
        hadi.setLevelTime("Level 2", 70);
        tom.setLevelTime("Level 2", 75);
        sam.setLevelTime("Level 2", 80);
        oscar.setLevelTime("Level 2", 85);

        laurence.setLevelTime("Level 3", 60);
        vlad.setLevelTime("Level 3", 65);
        hadi.setLevelTime("Level 3", 70);
        tom.setLevelTime("Level 3", 75);
        sam.setLevelTime("Level 3", 80);
        oscar.setLevelTime("Level 3", 85);

        laurence.setLevelTime("Level 4", 60);
        vlad.setLevelTime("Level 4", 65);
        hadi.setLevelTime("Level 4", 70);
        tom.setLevelTime("Level 4", 75);
        sam.setLevelTime("Level 4", 80);
        oscar.setLevelTime("Level 4", 85);

        laurence.setLevelTime("Level 5", 60);
        vlad.setLevelTime("Level 5", 65);
        hadi.setLevelTime("Level 5", 70);
        tom.setLevelTime("Level 5", 75);
        sam.setLevelTime("Level 5", 80);
        oscar.setLevelTime("Level 5", 85);

        ProfileManager.save(laurence);
        ProfileManager.save(vlad);
        ProfileManager.save(hadi);
        ProfileManager.save(tom);
        ProfileManager.save(sam);
        ProfileManager.save(oscar);
    }
}
