package com.group17.game.core;

import java.util.ArrayList;
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

    public static List<String> getTopTimes(String levelName, int amount) {
        compareLevel = levelName;
        List<Profile> profiles = ProfileManager.getProfiles(levelName);
        Collections.sort(profiles);
        List<String> topProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            topProfiles.add(profile.getName());
        }
        return topProfiles;
    }

    public static String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;
        int days = hours / 24;
        hours = hours % 24;

        if (days > 0) {
            return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
        } else if (hours > 0) {
            return hours + "h " + minutes + "m " + seconds + "s";
        } else if (minutes > 0) {
            return minutes + "m " + seconds + "s";
        }
        return seconds + "s";
    }

    public static int getProfileTime(String profileName, String levelName) {
        return ProfileManager.load(profileName).getLevelTime(levelName);
    }
}
