package com.group17.model;

import javafx.scene.image.Image;

import java.io.File;

public abstract class GameObject {
    protected static final String SPRITE_DIR = "../resources/sprites";
    protected static final String SPRITE_FILE_EXTENSION = "png";

    private Image sprite;

    public Image getSprite() {
        return sprite;
    }

    protected void setSprite(String spriteName) {
        File temp = new File(SPRITE_DIR + "/" + spriteName + "." + SPRITE_FILE_EXTENSION);
        if (temp.exists()) {
            sprite = new Image(temp.getPath());
        } else {
            sprite = new Image(SPRITE_DIR + "/missing." + SPRITE_FILE_EXTENSION);
        }
    }

    public GameObject(String spriteName) {
        setSprite(spriteName);
    }
}
