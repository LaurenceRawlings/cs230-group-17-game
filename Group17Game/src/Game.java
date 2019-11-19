import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Game {
    private final String LEVEL_DIR = "./Levels";
    private final String LEVEL_FILE_DECLARATOR = "<Level File>";
    private final String LEVEL_FILE_EXTENSION = "txt";

    private PriorityQueue<Level> levelQueue;
    private Level currentLevel;
    private Player player;
    private Profile profile;

    public Game(Profile profile) {
        this.profile = profile;
        readLevels();
    }

    private void readLevels() {
        File levelDirectory = new File(LEVEL_DIR);
        File[] levelFiles = levelDirectory.listFiles();

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
                                levelQueue.add(createLevel(levelData.toArray(new String[0])));
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
    }

    private Level createLevel(String[] levelData) {
        try {
            String levelName = levelData[0];
            String levelNumber = levelData[1];
            String[] dimensions = levelData[2].split(",");
            String[] startPosition = levelData[3].split(",");
            String tokens = levelData[4];

            Level newLevel = new Level(player, Integer.parseInt(levelNumber), levelName,
                    Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),
                    new Position(Integer.parseInt(startPosition[0]), Integer.parseInt(startPosition[1])),
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
