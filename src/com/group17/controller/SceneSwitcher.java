package com.group17.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
    private Stage main;

    public SceneSwitcher(Stage main) {
        this.main = main;
    }

    public void activate(Scene scene){
        main.setScene(scene);
    }
}
