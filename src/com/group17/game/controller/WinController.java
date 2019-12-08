package com.group17.game.controller;

import com.group17.game.core.Leaderboard;
import com.group17.game.core.LevelReader;
import com.group17.game.core.ProfileManager;
import com.group17.game.model.world.Level;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class WinController {

    @FXML
    private Label lbl_profile;


    @FXML
    private Label lbl_time;

    @FXML
    private ComboBox<String> cmb_language;


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

    public void onLoad() {
        cmb_language.setItems(FXCollections.observableArrayList(SceneController.getLanguages()));

        int totalTime = 0;
        List<String> levels = LevelReader.getLevelNames();
        for (int i = 0; i <= ProfileManager.getActiveProfile().getHighestLevel(); i++) {
            if (!(i >= levels.size())) {
                totalTime += Leaderboard.getProfileTime(ProfileManager.getActiveProfile().toString(), levels.get(i));
            }
        }

        lbl_time.setText(Leaderboard.formatTime(totalTime));

        if (ProfileManager.getActiveProfile() != null) {
            lbl_profile.setText(ProfileManager.getActiveProfile().toString());
        } else {
            lbl_profile.setText("None");
        }
    }

    @FXML
    void setLanguage() {
        String language = cmb_language.getSelectionModel().getSelectedItem();
        if (language != null) {
            SceneController.loadLanguage(language);
            onLoad();
        }
    }
}
