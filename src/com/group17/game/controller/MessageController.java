package com.group17.game.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MessageController {
    public static void showMessage(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static String inputDialog(String title, String header, String message, String defaultText) {
        TextInputDialog alert = new TextInputDialog(defaultText);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        Optional<String> result = alert.showAndWait();
        if (result.isPresent()) {
            return alert.getEditor().getText();
        } else {
            return null;
        }
    }
}
