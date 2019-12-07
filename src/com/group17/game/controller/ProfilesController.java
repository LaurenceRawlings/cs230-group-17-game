package com.group17.game.controller;

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
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ProfilesController {
    @FXML
    private Label lbl_profile;

    @FXML
    private ListView<String> lst_profiles;

    @FXML
    void initialize() {
        ObservableList<String> profiles = FXCollections.observableArrayList(ProfileManager.getProfileNames());
        lst_profiles.setItems(profiles);
    }

    @FXML
    void onClickBtnEnter(MouseEvent event) {
        String selectedProfile = lst_profiles.getSelectionModel().getSelectedItem();
        if (selectedProfile != null) {
            ProfileManager.setActiveProfile(ProfileManager.load(selectedProfile));
            enter();
        } else if (ProfileManager.getActiveProfile() != null) {
            enter();
        }
        else {
            MessageController.showMessage("Hold Up!", "Select a Profile", "Please select or create a profile before entering.");
        }
    }

    private void enter() {
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
    void onClickBtnCreate(MouseEvent event) {
        String name = "Player";
        name = MessageController.inputDialog("New Profile", "Create A New Profile", "Enter the name for the new profile: ", "New Profile");
        if (name != null) {
            if (!ProfileManager.exists(name)) {
                Profile profile = new Profile(name);
                ProfileManager.save(profile);
                ProfileManager.setActiveProfile(profile);
                initialize();
                onLoad();
            } else {
                MessageController.showMessage("Hold Up!", "Profile Already Exists!", "A profile with that name already exists, choose another name.");
            }
        }
    }

    @FXML
    void onClickBtnDelete(MouseEvent event) {
        try {
            String profile = lst_profiles.getSelectionModel().getSelectedItem();
            if (profile != null) {
                if (ProfileManager.getActiveProfile() != null) {
                    if (profile.equals(ProfileManager.getActiveProfile().toString())) {
                        ProfileManager.setActiveProfile(null);
                    }
                }
                ProfileManager.delete(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initialize();
        onLoad();
    }

    public void onLoad() {
        if (ProfileManager.getActiveProfile() != null) {
            lbl_profile.setText(ProfileManager.getActiveProfile().toString());
        } else {
            lbl_profile.setText("None");
        }
    }
}
