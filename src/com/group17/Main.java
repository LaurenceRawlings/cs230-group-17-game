package com.group17;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
            game.move("right");
            break;
         case LEFT:
            Player.move("left");
            break;
         case UP:
            Player.move("up");
            break;
         case DOWN:
            Player.move("down");
            break;
         default:
            break;
    }

  }
    public static void main(String[] args) {
        launch(args);
    }
}
