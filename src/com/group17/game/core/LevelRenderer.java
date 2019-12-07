package com.group17.game.core;

import com.group17.game.model.entity.Player;
import com.group17.game.model.world.Level;
import com.group17.game.model.world.TokenDoor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LevelRenderer {
    private static final String SPRITE_DIR = "com/group17/game/game/resources/sprites";
    private static final String SPRITE_FILE_EXTENSION = "png";
    private static final int SPRITE_WIDTH = 100;
    private static final int SPRITE_HEIGHT = 100;

    private static Image getSprite(String spriteName) {
        try {
            return new Image(SPRITE_DIR + "/" + spriteName + "." + SPRITE_FILE_EXTENSION, SPRITE_WIDTH, SPRITE_HEIGHT, false, true);
        } catch (IllegalArgumentException e) {
            try {
                return new Image(SPRITE_DIR + "/missing." + SPRITE_FILE_EXTENSION, SPRITE_WIDTH, SPRITE_HEIGHT, false, true);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void render(Game game, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int fov = game.getFov();
        Level level = game.getCurrentLevel();
        Player player = game.getPlayer();
        Position playerPosition = player.getPosition();

        int drawX = 0;
        int drawY = 0;

        for (int y = playerPosition.y() - fov; y <= playerPosition.y() + fov; y++) {
            for (int x = playerPosition.x() - fov; x <= playerPosition.x() + fov; x++) {
                if (y < 0 || x < 0 || y > level.getHeight()-1 || x > level.getWidth()-1) {
                    gc.drawImage(getSprite("null"), drawX * SPRITE_WIDTH, drawY * SPRITE_HEIGHT);
                } else {
                    if (level.getCell(new Position(x, y)) != null) {
                        Image i = getSprite(level.getCell(new Position(x, y)).getSpriteName());
                        gc.drawImage(getSprite(level.getCell(new Position(x, y)).getSpriteName()), drawX * SPRITE_WIDTH, drawY * SPRITE_HEIGHT);
                        if (level.getCell(new Position(x, y)) instanceof TokenDoor) {
                            gc.setFill(Color.web("#ffffff"));
                            gc.setFont(Font.font("Segoe UI", 18));
                            gc.fillText(Integer.toString(((TokenDoor) level.getCell(new Position(x, y))).getTokenCost()), drawX * SPRITE_WIDTH + SPRITE_WIDTH/2, drawY * SPRITE_HEIGHT + SPRITE_HEIGHT/2);
                        }
                    } else {
                        gc.drawImage(getSprite("null"), drawX * SPRITE_WIDTH, drawY * SPRITE_HEIGHT);
                    }
                    if (level.getItem(new Position(x, y)) != null) {
                        gc.drawImage(getSprite(level.getItem(new Position(x, y)).getSpriteName()), drawX * SPRITE_WIDTH, drawY * SPRITE_HEIGHT);
                    }
                    if (level.getEnemy(new Position(x, y)) != null) {
                        gc.drawImage(getSprite(level.getEnemy(new Position(x, y)).getSpriteName()), drawX * SPRITE_WIDTH, drawY * SPRITE_HEIGHT);
                    }
                }
                drawX++;
            }
            drawX = 0;
            drawY++;
        }
        gc.drawImage(getSprite(player.getSpriteName()), fov * SPRITE_WIDTH, fov * SPRITE_HEIGHT);
    }
}
