package com.group17.core;

import com.group17.model.entity.*;
import com.group17.model.world.Level;
import com.group17.model.world.Obstacle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Game {
    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;
    private Profile profile;

    public Game(Profile profile) {
        this.profile = profile;
        LevelReader.readLevels();
    }
    /*I handle the key in this method and depending on the pressed key call the move
     fnctuins with different inputs */
     


//------------------------------------Passing Obstacles --------------------------------------------------------->


    //Check if player has correct boots, if they do then they can pass the obstacle

    public boolean PassObstacle(Obstacle o) {


        if (player.checkBoots(o.getCounterBoots())) {
            return true;
        } else {
            return false;
        }

    }

    //------------------------------------------------------------------------------------------------------------>

}
