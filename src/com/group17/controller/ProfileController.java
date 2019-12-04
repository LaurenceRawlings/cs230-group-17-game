package com.group17.controller;

import com.group17.core.Profile;
import com.group17.core.ProfileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ProfileController {
    private SceneSwitcher controller;

    private Profile profile;

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            lbl_profile.setText(profile.getName());
        }
    }

    public void setController(SceneSwitcher controller) {
        this.controller = controller;
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
    private ListView<String> lst_profiles;

    @FXML
    private Label btn_load;

    @FXML
    private Label btn_create;

    @FXML
    private Label btn_back;

    @FXML
    private VBox root_top;

    @FXML
    private Label lbl_title;

    @FXML
    private Label btn_delete;

    @FXML
    void initialize() {
        ObservableList<String> profiles = FXCollections.observableArrayList(ProfileManager.getProfileNames());
        lst_profiles.setItems(profiles);
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
    void onClickBtnCreate(MouseEvent event) {
        String name = "Player";
        name = ControllerHelpers.inputDialog("New Profile", "Create A New Profile", "Enter the name for the new profile: ");
        if (!ProfileManager.exists(name)) {
            profile = new Profile(name);
            ProfileManager.save(profile);
            initialize();
        } else {
            ControllerHelpers.showMessage("Hold Up!", "Profile Already Exists!", "A profile with that name already exists, choose another name.");
        }
    }

    @FXML
    void onClickBtnLoad(MouseEvent event) {
        setProfile(ProfileManager.load(lst_profiles.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void onClickBtnDelete(MouseEvent event) {
        try {
            ProfileManager.delete(lst_profiles.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initialize();;
    }
}
