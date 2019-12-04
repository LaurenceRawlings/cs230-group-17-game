package com.group17.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class ControllerHelpers {
    public static void showMessage(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static String inputDialog(String title, String header, String message) {
        TextInputDialog alert = new TextInputDialog("Profile Name");
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
        return alert.getEditor().getText();
    }
}
