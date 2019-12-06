package com.group17.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Profile p1 = new Profile("Top");
        Profile p2 = new Profile("Middle");
        Profile p3 = new Profile("Bottom");

        p1.setLevelTime("test", 1);
        p2.setLevelTime("test", 4);
        p3.setLevelTime("test", 3);

        ProfileManager.save(p1);
        ProfileManager.save(p2);
        ProfileManager.save(p3);

        System.out.println(Arrays.toString(Leaderboard.getTopTimes("test", 5)));
    }
}

