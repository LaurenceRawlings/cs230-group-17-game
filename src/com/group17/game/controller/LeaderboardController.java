package com.group17.game.controller;

import com.group17.game.core.Leaderboard;
import com.group17.game.core.LevelReader;
import com.group17.game.core.MessageOfTheDay;
import com.group17.game.core.Profile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class LeaderboardController {
    private SceneController controller;
    private Profile profile;
    private Timeline timer;
    private Label[] podium;

    public void setController(SceneController controller) {
        this.controller = controller;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            lbl_profile.setText(profile.getName());
        }
    }

    @FXML
    private Label lbl_profile;

    @FXML
    private ComboBox<String> cmb_levels;

    @FXML
    private Label lbl_first;

    @FXML
    private Label lbl_second;

    @FXML
    private Label lbl_third;

    @FXML
    private Label lbl_motd;

    @FXML
    void initialize() {
        lbl_motd.setText(MessageOfTheDay.get());
        timer = new Timeline(new KeyFrame(Duration.seconds(30), event -> lbl_motd.setText(MessageOfTheDay.get())));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        ObservableList<String> levels = FXCollections.observableArrayList(LevelReader.getLevelNames());
        cmb_levels.setItems(levels);
        podium = new Label[] {
                lbl_first,
                lbl_second,
                lbl_third
        };
    }

    @FXML
    void levelChanged(ActionEvent event) {
        for (int i = 0; i < podium.length; i++) {
            podium[i].setText("[EMPTY]");
        }
        String level  = cmb_levels.getSelectionModel().getSelectedItem();
        List<String> profiles = Leaderboard.getTopTimes(level, 3);
        int podiumPosition = 0;
        for (String profile : profiles) {
            podium[podiumPosition].setText(profile + " - " + Leaderboard.formatTime(Leaderboard.getProfileTime(profile, level)));
            podiumPosition++;
        }
    }

    @FXML
    void obClickBtnBack(MouseEvent event) {
        try {
            timer.stop();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/menu.fxml"));
            Parent root = loader.load();
            MenuController menu = loader.getController();
            menu.setController(controller);
            menu.setProfile(profile);

            controller.activate(new Scene(root, 1000, 1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
