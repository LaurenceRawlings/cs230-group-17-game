package com.group17.game.controller;

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

public class LevelsController {
    @FXML
    private Label lbl_profile;

    @FXML
    private ListView<String> lst_levels;

    @FXML
    void initialize() {

    }

    @FXML
    void onClickBtnBack(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/menu.fxml"));
            Parent root = loader.load();
            MenuController menu = loader.getController();
            menu.onLoad();

            SceneController.activate(new Scene(root, 1000, 1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnPlay(MouseEvent event) {
        if (lst_levels.getSelectionModel().getSelectedItem() != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/game.fxml"));
                Parent root = loader.load();
                GameController game = loader.getController();

                Scene scene = new Scene(root, 1000, 1000);
                scene.addEventFilter(KeyEvent.KEY_PRESSED, game::keyPressed);
                ProfileManager.getActiveProfile().newGame(lst_levels.getSelectionModel().getSelectedIndex());

                game.onLoad();
                SceneController.activate(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onLoad() {
        List<String> availableLevels = new ArrayList<>();
        for (int i = 0; i <= ProfileManager.getActiveProfile().getHighestLevel() + 1; i++) {
            if (i < LevelReader.getLevelQueue().size()) {
                availableLevels.add(LevelReader.getLevelQueue().get(i).toString());
            }
        }
        ObservableList levels = FXCollections.observableArrayList(availableLevels);
        lst_levels.setItems(levels);

        if (ProfileManager.getActiveProfile() != null) {
            lbl_profile.setText(ProfileManager.getActiveProfile().toString());
        } else {
            lbl_profile.setText("None");
        }
    }
}
