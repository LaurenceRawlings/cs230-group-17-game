package com.group17.game.controller;

import com.group17.game.core.MessageOfTheDay;
import com.group17.game.core.Profile;
import com.group17.game.core.ProfileManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;

public class MenuController {
    @FXML
    private Label lbl_profile;

    @FXML
    private Label btn_quit;

    @FXML
    private Label lbl_motd;

    @FXML
    private BorderPane root;

    @FXML
    void initialize() {
        lbl_motd.setText(MessageOfTheDay.get());
        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(30), event -> lbl_motd.setText(MessageOfTheDay.get())));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    @FXML
    void onClickBtnContinue(MouseEvent event) {
        if (ProfileManager.getActiveProfile() == null) {
            MessageController.showMessage("Hold Up!","Select a Profile","Before you can begin you must either select a profile or create a new one.");
        } else {
            startGame();
        }
    }

    @FXML
    void onClickBtnQuit(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void onClickBtnNew(MouseEvent event) {
        if (ProfileManager.getActiveProfile() == null) {
            MessageController.showMessage("Hold Up!","Select a Profile","Before you can begin you must either select a profile or create a new one.");
        } else {
            ProfileManager.getActiveProfile().newGame();
            startGame();
        }
    }

    @FXML
    void onClickBtnProfile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/profiles.fxml"));
            Parent root = loader.load();
            ProfilesController profiles = loader.getController();
            profiles.onLoad();

            SceneController.activate(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnLeaderboard(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/leaderboard.fxml"));
            Parent root = loader.load();
            LeaderboardController leaderboard = loader.getController();
            leaderboard.onLoad();

            SceneController.activate(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnLevel(MouseEvent event) {
        if (ProfileManager.getActiveProfile() == null) {
            MessageController.showMessage("Hold Up!","Select a Profile","Before you can begin you must either select a profile or create a new one.");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/levels.fxml"));
                Parent root = loader.load();
                LevelsController levels = loader.getController();
                levels.onLoad();

                SceneController.activate(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/game.fxml"));
            Parent root = loader.load();
            GameController game = loader.getController();

            Scene scene = new Scene(root);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, game::keyPressed);

            game.onLoad();
            SceneController.activate(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onLoad() {
        if (ProfileManager.getActiveProfile() != null) {
            lbl_profile.setText(ProfileManager.getActiveProfile().toString());
        } else {
            lbl_profile.setText("None");
        }
    }
}
