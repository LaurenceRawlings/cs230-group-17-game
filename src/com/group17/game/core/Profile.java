/**
 * Class defines the profile of a user. Determines highest level reached and time taken to complete.
 * @author
 */

package com.group17.game.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Profile implements Serializable, Comparable<Profile> {
    private Game game;
    private final String name;
    private final Map levelTimes;
    private int highestLevel;
    
    /**
	 * Method to get the highest level reached by a user
	 * @return highestLevel
	 */

    public int getHighestLevel() {
        return highestLevel;
    }
    
    /**
	 * Method to set the highest level reached by a user
	 * @param highestLevel 
	 */

    public void setHighestLevel(int highestLevel) {
        this.highestLevel = highestLevel;
    }
    
    /**
	 * Method to get the time that it takes for a user to complete
	 * @param levelName
	 * @return the level times
	 */

    public int getLevelTime(String levelName) {
        if (levelTimes.containsKey(levelName)) {
            return (int) levelTimes.get(levelName);
        } else {
            return (int) Double.POSITIVE_INFINITY;
        }
    }

    /**
	 * Method to check if a level is complete
	 * @return true or false if complete or not
	 */
    
    public boolean levelCompleted(String levelName) {
        return levelTimes.containsKey(levelName);
    }
    
    /**
	 * Method to set the time that it takes to complete a level
	 * @param levelName
	 * @param time
	 */

    public void setLevelTime(String levelName, int time) {
        levelTimes.put(levelName, time);
    }

    public Game getGame() {
        return game;
    }

    @Override
    public String toString() {
        return name;
    }

    public Profile(String name) {
        this.name = name;
        game = new Game();
        levelTimes = new HashMap();
        highestLevel = -1;
    }
    
    /**
	 * Method to set a new game
	 */

    public void newGame() {
        game = new Game();
    }
    
    /**
	 * Method to set a new game at a certain level
	 * @param levelIndex
	 */

    public void newGame(int levelIndex) {
        game = new Game(levelIndex);
    }

    /**
	 * Method to compare level reached to levels on the leader board
	 * @param profile
	 */
    
    @Override
    public int compareTo(Profile profile) {
        String compareLevel = Leaderboard.getCompareLevel();

        if (compareLevel == null) {
            return 0;
        }

        return Integer.compare(getLevelTime(compareLevel), profile.getLevelTime(compareLevel));
    }
}
