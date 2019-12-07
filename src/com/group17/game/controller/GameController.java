package com.group17.game.controller;

import com.group17.game.core.*;
import com.group17.game.model.entity.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {
    private Profile profile;
    private Game game;
    private SceneController controller;
    private Timeline timer;

    public void setController(SceneController controller) {
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
    private Canvas canvas;

    @FXML
    private Label lbl_title;

    @FXML
    private Label lbl_timer;

    @FXML
    private Label lbl_profile;

    @FXML
    private ListView<String> lst_inventory;

    @FXML
    void initialize() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            int time = game.getCurrentLevel().getTime();
            game.getCurrentLevel().setTime(++time);
            lbl_timer.setText(Leaderboard.formatTime(time));
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

        ObservableList items = FXCollections.observableArrayList(game.getPlayer().getItems());
        lst_inventory.setItems(items);

        event.consume();
    }

    private void drawGame() {
        LevelRenderer.render(game, canvas);
        lbl_title.setText(game.getCurrentLevel().toString());
    }

    public void onLoad() {
        drawGame();
        lbl_timer.setText(Leaderboard.formatTime(game.getCurrentLevel().getTime()));
    }

    @FXML
    void onClickBtnSave(MouseEvent event) {
        try {
            timer.stop();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/menu.fxml"));
            Parent root = loader.load();
            MenuController menu = loader.getController();
            menu.setController(controller);
            menu.setProfile(profile);
            ProfileManager.save(profile);

            controller.activate(new Scene(root, 1000, 1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}