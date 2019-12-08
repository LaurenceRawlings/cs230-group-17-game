package com.group17.game.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class SceneController {
    private static Stage main = new Stage();

    private static ResourceBundle languageBundle = ResourceBundle.getBundle("com.group17.game.locale.lang", new Locale("fa"));
    private static final List<String> languages = new ArrayList<String>() {
        {
            add("EN");
            add("UK");
            add("RU");
            add("FA");
        }
    };

    public static ResourceBundle getLanguageBundle() {
        return languageBundle;
    }

    public static void setMain(Stage main) {
        SceneController.main = main;
    }

    public static void activate(Scene scene) {
        main.setScene(scene);
    }

    public static List<String> getLanguages() {
        return languages;
    }

    public static void loadLanguage(String language) {
        Locale locale = new Locale(language.toLowerCase());
        languageBundle = ResourceBundle.getBundle("com.group17.game.locale.lang", locale);
    }
}
