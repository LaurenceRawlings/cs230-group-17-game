package com.group17.core;

import com.group17.model.world.Level;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//File Layout
/*

<Level File>                    //Declarator
1; Level 1                      //Level Number; Level Name
10,10;1,1;8,8                   //Width, Height; Start x, Start y; Finish x, Finish y
2,2,7,7;3,3,6,6                 //Teleporters: Origin x, Origin y, Destination x, Destination y; ...
1,3,smart,down;8,6,line,left    //Enemies: Spawn x, Span y, Type (smart, dumb, wall, line), Direction (up, down, left, right); ...
1,5,fire;1,6,water              //Obstacles: Position x, Position y, Type (fire, water); ...
1,2,fire boots;1,3,water boots  //Items: Position x, Position y, Type (fire boots, water boots);  ...
##########                      //Level Layout - Walls, Ground, Obstacles, Doors and Items
#      @ #
#        #                      #       = Wall
#  @   a #                      'space' = Ground
#    @   #                      @       = Token
# #####A##                      1-9     = Token Door (Number = Token Cost)
# @      #                      A-Z     = Key Door (Matching key is corresponding lowercase letter)
#      ###                      a-z     = Key
# @    5 #
##########                      (Other characters can be used but will be ignored, helpful for visualising layout)

*/


public class LevelReader {
    private static final String LEVEL_DIR = "./Levels";
    private static final String LEVEL_FILE_DECLARATOR = "<Level File>";
    private static final String LEVEL_FILE_EXTENSION = "txt";

    public static List<Level> readLevels() {
        File levelDirectory = new File(LEVEL_DIR);
        File[] levelFiles = levelDirectory.listFiles();
        List<Level> levels = new ArrayList<>();

        try {
            if (levelFiles != null) {
                for (File level : levelFiles) {
                    String[] levelPath = level.getAbsolutePath().split("\\.");
                    if (levelPath[levelPath.length - 1].equals(LEVEL_FILE_EXTENSION) && level.isFile()) {
                        Scanner scanner = new Scanner(level);
                        if (scanner.hasNextLine()) {
                            if (scanner.nextLine().equals(LEVEL_FILE_DECLARATOR)) {
                                List<String> levelData = new ArrayList<>();
                                while (scanner.hasNextLine()) {
                                    levelData.add(scanner.nextLine());
                                }
                                levels.add(createLevel(levelData.toArray(new String[0])));
                            }
                        }
                        scanner.close();
                    }
                }
            } else {
                throw new IOException(levelDirectory + " not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return levels;
    }

    private static Level createLevel(String[] levelData) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
