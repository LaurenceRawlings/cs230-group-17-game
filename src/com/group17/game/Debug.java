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
        hadi.setLevelTime("Level 1", 71);
        tom.setLevelTime("Level 1", 76);
        sam.setLevelTime("Level 1", 82);
        oscar.setLevelTime("Level 1", 87);

        laurence.setLevelTime("Level 2", 93);
        vlad.setLevelTime("Level 2", 98);
        hadi.setLevelTime("Level 2", 104);
        tom.setLevelTime("Level 2", 109);
        sam.setLevelTime("Level 2", 110);
        oscar.setLevelTime("Level 2", 115);

        laurence.setLevelTime("Level 3", 120);
        vlad.setLevelTime("Level 3", 125);
        hadi.setLevelTime("Level 3", 131);
        tom.setLevelTime("Level 3", 136);
        sam.setLevelTime("Level 3", 142);
        oscar.setLevelTime("Level 3", 147);

        laurence.setLevelTime("Level 4", 153);
        vlad.setLevelTime("Level 4", 158);
        hadi.setLevelTime("Level 4", 164);
        tom.setLevelTime("Level 4", 169);
        sam.setLevelTime("Level 4", 170);
        oscar.setLevelTime("Level 4", 180);

        laurence.setLevelTime("Level 5", 185);
        vlad.setLevelTime("Level 5", 190);
        hadi.setLevelTime("Level 5", 191);
        tom.setLevelTime("Level 5", 206);
        sam.setLevelTime("Level 5", 202);
        oscar.setLevelTime("Level 5", 217);

        ProfileManager.save(laurence);
        ProfileManager.save(vlad);
        ProfileManager.save(hadi);
        ProfileManager.save(tom);
        ProfileManager.save(sam);
        ProfileManager.save(oscar);
    }
}
