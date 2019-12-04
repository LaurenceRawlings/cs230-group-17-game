package com.group17;

import com.group17.controller.MenuController;
import com.group17.controller.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneSwitcher controller = new SceneSwitcher(primaryStage);

        primaryStage.setTitle("Group 17 Game");
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menu.fxml"));
        Parent root = loader.load();
        MenuController menu = loader.getController();
        menu.setController(controller);

        controller.activate(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
