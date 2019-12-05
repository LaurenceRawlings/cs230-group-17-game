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

import java.io.IOException;

public class ProfileController {
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
    private ListView<String> lst_profiles;

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
        name = MessageController.inputDialog("New Profile", "Create A New Profile", "Enter the name for the new profile: ", "New Profile");
        if (name != null) {
            if (!ProfileManager.exists(name)) {
                profile = new Profile(name);
                ProfileManager.save(profile);
                initialize();
            } else {
                MessageController.showMessage("Hold Up!", "Profile Already Exists!", "A profile with that name already exists, choose another name.");
            }
        }
    }

    @FXML
    void onClickBtnLoad(MouseEvent event) {
        String profile  = lst_profiles.getSelectionModel().getSelectedItem();
        if (profile != null) {
            setProfile(ProfileManager.load(profile));
        }
    }

    @FXML
    void onClickBtnDelete(MouseEvent event) {
        try {
            String profile  = lst_profiles.getSelectionModel().getSelectedItem();
            if (profile != null) {
                ProfileManager.delete(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initialize();
    }
}
