package com.group17.core;

import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private static String compareLevel;

    public static void setCompareLevel(String levelName) {
        compareLevel = levelName;
    }

    public static String getCompareLevel() {
        return compareLevel;
    }

    public static String[] getTopTimes(String levelName, int amount) {
        compareLevel = levelName;
        List<Profile> profiles = ProfileManager.getProfiles(levelName);
        Collections.sort(profiles);
        for (int i = 0; i < amount; i++) {
            profiles.add(new Profile(""));
        }
        String[] topProfiles = new String[amount];
        for (int i = 0; i < amount; i++) {
            topProfiles[i] = profiles.get(i).getName();
        }
        return topProfiles;
    }
}
