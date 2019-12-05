package com.group17.controller;

import com.group17.core.MOTD;
import com.group17.core.Profile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private Profile profile;
    private SceneSwitcher controller;

    public void setController(SceneSwitcher controller) {
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
    private BorderPane root;

    @FXML
    private HBox root_bottom;

    @FXML
    private Label lbl_profile;

    @FXML
    private VBox root_left;

    @FXML
    private VBox root_right;

    @FXML
    private VBox root_main;

    @FXML
    private Label btn_continue;

    @FXML
    private Label btn_new;

    @FXML
    private Label btn_profile;

    @FXML
    private Label btn_leaderboard;

    @FXML
    private Label btn_quit;

    @FXML
    private VBox root_top;

    @FXML
    private Label lbl_title;

    @FXML
    private Label lbl_motd;

    @FXML
    void initialize() {
        //lbl_motd.setText(MOTD.get());
    }

    @FXML
    void onClickBtnContinue(MouseEvent event) {
        if (profile == null) {
            ControllerHelpers.showMessage("Hold Up!","Select a Profile","Before you can begin you must either select a profile or create a new one.");
        } else {
            startGame();
        }
    }

    @FXML
    void onClickBtnQuit(MouseEvent event) {
        Stage stage = (Stage) btn_quit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickBtnNew(MouseEvent event) {
        if (profile == null) {
            ControllerHelpers.showMessage("Hold Up!","Select a Profile","Before you can begin you must either select a profile or create a new one.");
        } else {
            profile.newGame();
            startGame();
        }
    }

    @FXML
    void onClickBtnProfile(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/profiles.fxml"));
            Parent root = loader.load();
            ProfileController profiles = loader.getController();
            profiles.setController(controller);
            profiles.setProfile(profile);

            controller.activate(new Scene(root, 1000, 1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickBtnLeaderboard(MouseEvent event) {
    }

    private void startGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/game.fxml"));
            Parent root = loader.load();
            GameController game = loader.getController();
            game.setController(controller);
            game.setProfile(profile);

            Scene scene = new Scene(root, 1000, 1000);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> game.keyPressed(event));

            game.onLoad();
            controller.activate(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
