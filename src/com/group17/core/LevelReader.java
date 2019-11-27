package com.group17.core;

import com.group17.model.entity.enemy.DumbFollowingEnemy;
import com.group17.model.entity.enemy.SmartFollowingEnemy;
import com.group17.model.entity.enemy.StraightLineEnemy;
import com.group17.model.entity.enemy.WallFollowingEnemy;
import com.group17.model.world.Level;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                return levels;
            } else {
                throw new IOException(levelDirectory + " not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Level createLevel(String[] levelData) {
        try {
            String levelName = levelData[0];
            String levelNumber = levelData[1];
            String[] dimensions = levelData[2].split(",");
            String[] startPosition = levelData[3].split(",");
            String tokens = levelData[4];

            Level newLevel = new Level(new Position(Integer.parseInt(startPosition[0]),
                    Integer.parseInt(startPosition[1])), Integer.parseInt(levelNumber), levelName,
                    Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),
                    Integer.parseInt(tokens));

            for (String current : levelData[5].split(";")) {
                String[] enemy = current.split(",");
                Position position = new Position(Integer.parseInt(enemy[0]), Integer.parseInt(enemy[1]));

                switch (enemy[2]) {
                    case "A":
                        newLevel.setEnemy(position, new SmartFollowingEnemy(position));
                        break;
                    case "B":
                        newLevel.setEnemy(position, new WallFollowingEnemy(position));
                        break;
                    case "C":
                        newLevel.setEnemy(position, new DumbFollowingEnemy(position));
                        break;
                    case "D":
                        newLevel.setEnemy(position, new StraightLineEnemy(position));
                        break;
                }
            }

            return newLevel;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
