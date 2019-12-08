/**
 * Class defines the leader board. This class contains the methods required
 * to order profiles in accordance to the level reached and amount of time for completion.
 * @author
 */
package com.group17.game.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Leaderboard {
    private static String compareLevel;
    
   /**
    * Method to get the level to be compared.
    * @return compareLevel
    */

    public static String getCompareLevel() {
        return compareLevel;
    }
    
    /**
	 * Method to get all of the top times.
	 * @param levelName
	 * @param amount
	 * @return topProfiles
	 */

    public static List<String> getTopTimes(String levelName, int amount) {
        compareLevel = levelName;
        List<Profile> profiles = ProfileManager.getProfiles(levelName);
        Collections.sort(profiles);
        List<String> topProfiles = new ArrayList<>();
        int i = 0;
        for (Profile profile : profiles) {
            if (i >= amount) {
                return topProfiles;
            }
            topProfiles.add(profile.toString());
            i++;
        }
        return topProfiles;
    }
    
    /**
	 * Method to get the time calculated based off of time in seconds.
	 * @param seconds
	 * @return days, hours, minutes, seconds depending on the parameter amount
	 */

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
    
    /**
	 * Method to get the level name, profile name and time taken to complete the attempt
	 * @param profileName
	 * @param levelName
	 * @return levelName and profileName that are not null
	 */

    public static int getProfileTime(String profileName, String levelName) {
        return Objects.requireNonNull(ProfileManager.load(profileName)).getLevelTime(levelName);
    }
}
