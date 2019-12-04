package com.group17.core;

import javafx.scene.image.Image;

import java.io.File;

public class LevelRenderer {
    protected static final String SPRITE_DIR = "com/group17/resources/sprites";
    protected static final String SPRITE_FILE_EXTENSION = "png";

    public Image getSprite(String spriteName) {
        File temp = new File(SPRITE_DIR + "/" + spriteName + "." + SPRITE_FILE_EXTENSION);
        if (temp.exists()) {
            return new Image(temp.getPath());
        } else {
            return new Image(SPRITE_DIR + "/missing." + SPRITE_FILE_EXTENSION);
        }
    }

}
