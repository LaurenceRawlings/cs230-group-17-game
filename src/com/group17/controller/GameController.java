package com.group17.controller;

import com.group17.core.Game;
import com.group17.core.LevelRenderer;
import com.group17.core.Profile;
import com.group17.model.entity.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class GameController {
    private Profile profile;
    private Game game;
    private SceneSwitcher controller;

    public void setController(SceneSwitcher controller) {
        this.controller = controller;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        game = profile.getGame();
        if (profile != null) {
            lbl_profile.setText(profile.getName());
        }
    }

    @FXML
    private BorderPane root;

    @FXML
    private VBox root_left;

    @FXML
    private Label lbl_inventory;

    @FXML
    private ListView<?> lst_inventory;

    @FXML
    private VBox root_right;

    @FXML
    private VBox root_main;

    @FXML
    private Canvas canvas;

    @FXML
    private VBox root_top;

    @FXML
    private Label lbl_title;

    @FXML
    private Label lbl_timer;

    @FXML
    private VBox root_bottom;

    @FXML
    private Label lbl_profile;

    @FXML
    void initialize() {
        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                game.move(Direction.up);
                break;
            case DOWN:
                game.move(Direction.down);
                break;
            case LEFT:
                game.move(Direction.left);
                break;
            case RIGHT:
                game.move(Direction.right);
                break;
            default:
                break;
        }
        drawGame();

        event.consume();
    }

    private void drawGame() {
        LevelRenderer.render(game, canvas);
        lbl_title.setText(game.getCurrentLevel().getLevelName());
    }
}