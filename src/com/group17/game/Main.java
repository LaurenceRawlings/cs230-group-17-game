package com.group17.game;

import com.group17.game.controller.ProfilesController;
import com.group17.game.controller.SceneController;
import com.group17.game.core.ProfileManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneController.setMain(primaryStage);

        primaryStage.setTitle("Indiana Jones and the Last Assignment - Group 17");
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/profiles.fxml"));
        Parent root = loader.load();
        ProfilesController profiles = loader.getController();

        SceneController.activate(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        if (ProfileManager.getActiveProfile() != null) {
            ProfileManager.save(ProfileManager.getActiveProfile());
        }
    }
}
