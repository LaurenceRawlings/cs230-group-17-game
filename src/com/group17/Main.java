package com.group17;

import com.group17.core.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/menu.fxml"));

        Scene scene = new Scene(root, 800, 600);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event));

        primaryStage.setTitle("Group 17 Game");
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
