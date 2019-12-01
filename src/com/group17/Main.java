package com.group17;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/game.fxml"));

        Scene scene = new Scene(root, 1000, 1000);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event));

        primaryStage.setTitle("Group 17 Game");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void processKeyEvent(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                break;
            case DOWN:
                break;
            case LEFT:
                break;
            case RIGHT:
                break;
            default:
                break;
        }

        event.consume();
  }
    public static void main(String[] args) {
        launch(args);
    }
}
