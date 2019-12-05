package com.group17.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage main;

    public SceneController(Stage main) {
        this.main = main;
    }

    public void activate(Scene scene){
        main.setScene(scene);
    }
}
