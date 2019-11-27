package com.group17;

import com.group17.core.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    private Game game;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../com/group17/view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void processKeyEvent(KeyEvent event) {
    switch (event.getCode()) {

        case RIGHT:
            break;
         case LEFT:
            break;
         case UP:
            break;
         case DOWN:
            break;
         default:
            break;
    }

  }
    public static void main(String[] args) {
        launch(args);
    }
}
