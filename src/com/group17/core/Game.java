package com.group17.core;

import com.group17.model.entity.*;
import com.group17.model.world.Level;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//testing git works
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
     


}