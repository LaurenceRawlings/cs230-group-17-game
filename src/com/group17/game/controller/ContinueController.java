package com.group17.game.controller;

import com.group17.game.core.Leaderboard;
import com.group17.game.core.LevelReader;
import com.group17.game.core.Profile;
import com.group17.game.core.ProfileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContinueController {
    private int nextLevelIndex = 0;

    public void setNextLevelIndex(int nextLevelIndex) {
        this.nextLevelIndex = nextLevelIndex;
    }

    @FXML
    private Label lbl_profile;

    @FXML
    private ListView<String> lst_times;

    @FXML
    void initialize() {

    }

    @FXML
    void onClickBtnMenu(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/menu.fxml"));
            Parent root = loader.load();
            MenuController menu = loader.getController();
            menu.onLoad();

            SceneController.activate(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnContinue(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/game.fxml"));
            Parent root = loader.load();
            GameController game = loader.getController();

            Scene scene = new Scene(root);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, game::keyPressed);
            ProfileManager.getActiveProfile().newGame(nextLevelIndex);

            game.onLoad();
            SceneController.activate(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onLoad() {
        List<String> topProfiles = Leaderboard.getTopTimes(LevelReader.getLevelQueue().get(nextLevelIndex - 1).toString(), ProfileManager.getProfileNames().size());
        List<String> topTimes = new ArrayList<>();

        for (String profile : topProfiles) {
            topTimes.add((topProfiles.indexOf(profile) + 1) + ". " + profile + " - " + Leaderboard.formatTime(Leaderboard.getProfileTime(profile, LevelReader.getLevelQueue().get(nextLevelIndex - 1).toString())));
        }

        ObservableList times = FXCollections.observableArrayList(topTimes);
        lst_times.setItems(times);

        if (ProfileManager.getActiveProfile() != null) {
            lbl_profile.setText(ProfileManager.getActiveProfile().toString());
        } else {
            lbl_profile.setText("None");
        }
    }
}