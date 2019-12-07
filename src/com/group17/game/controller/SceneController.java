package com.group17.game.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private static Stage main = new Stage();

    public static void setMain(Stage main) {
        SceneController.main = main;
    }

    public static void activate(Scene scene){
        main.setScene(scene);
    }
}
