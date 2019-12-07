package com.group17.game;

import com.group17.game.controller.ProfilesController;
import com.group17.game.controller.SceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneController controller = new SceneController(primaryStage);

        primaryStage.setTitle("Group 17 Game");
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/profiles.fxml"));
        Parent root = loader.load();
        ProfilesController profiles = loader.getController();
        profiles.setController(controller);

        controller.activate(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
