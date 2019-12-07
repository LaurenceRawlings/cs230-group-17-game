package com.group17.game.controller;

import com.group17.game.core.LevelReader;
import com.group17.game.core.Profile;
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
    private SceneController controller;
    private Profile profile;

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            lbl_profile.setText(profile.getName());
        }
    }

    public void setController(SceneController controller) {
        this.controller = controller;
    }

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
            menu.setController(controller);
            menu.setProfile(profile);

            controller.activate(new Scene(root, 1000, 1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnPlay(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/game.fxml"));
            Parent root = loader.load();
            GameController game = loader.getController();
            game.setController(controller);

            Scene scene = new Scene(root, 1000, 1000);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, game::keyPressed);
            profile.newGame(lst_levels.getSelectionModel().getSelectedIndex());
            game.setProfile(profile);

            game.onLoad();
            controller.activate(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onLoad() {
        List<String> availableLevels = new ArrayList<>();
        for (int i = 0; i < profile.getHighestLevel() + 1; i++) {
            if (i < LevelReader.getLevelQueue().size()) {
                availableLevels.add(LevelReader.getLevelQueue().get(i).toString());
            }
        }
        ObservableList levels = FXCollections.observableArrayList(availableLevels);
        lst_levels.setItems(levels);
    }
}
