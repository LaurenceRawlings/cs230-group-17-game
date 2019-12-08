package com.group17.game.core;

import com.group17.game.model.entity.Player;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileManager {
    private static final String PROFILE_DIR = "./src/com/group17/game/resources/profiles";
    private static final String PROFILE_FILE_EXTENSION = "save";

    private static Profile activeProfile;
    private static Player.Skin character = Player.Skin.man;

    public static Player.Skin getCharacter() {
        return character;
    }

    public static void setCharacter(Player.Skin character) {
        ProfileManager.character = character;
    }

    public static Profile getActiveProfile() {
        return activeProfile;
    }

    public static void setActiveProfile(Profile activeProfile) {
        ProfileManager.activeProfile = activeProfile;
    }

    public static Profile load(String name) {
        if (exists(name)) {
            Profile profile = null;
            try {
                FileInputStream file = new FileInputStream(PROFILE_DIR + "/" + name + "." + PROFILE_FILE_EXTENSION);
                ObjectInputStream serial = new ObjectInputStream(file);

                profile = (Profile) serial.readObject();

                serial.close();
                file.close();
            } catch(IOException e) {
                System.out.println("Save file not Found!");
                e.printStackTrace();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }

            return profile;
        } else {
            return null;
        }
    }

    public static void save(Profile profile) {
        try {
            FileOutputStream file = new FileOutputStream(PROFILE_DIR + "/" + profile.toString() + "." + PROFILE_FILE_EXTENSION);
            ObjectOutputStream serial = new ObjectOutputStream(file);

            serial.writeObject(profile);

            serial.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean exists(String name) {
        return getProfileNames().contains(name);
    }

    public static void delete(String name) throws Exception {
        if (exists(name)) {
            try {
                Files.deleteIfExists(Paths.get(PROFILE_DIR + "/" + name + "." + PROFILE_FILE_EXTENSION));
            } catch(NoSuchFileException e) {
                e.printStackTrace();
                System.out.println("No such file/directory exists");
            } catch(DirectoryNotEmptyException e) {
                e.printStackTrace();
                System.out.println("Directory is not empty.");
            } catch(IOException e) {
                e.printStackTrace();
                System.out.println("Invalid permissions.");
            }
        } else{
            throw new Exception("Profile not found!");
        }
    }

    public static List<String> getProfileNames() {
        File profileDirectory = new File(PROFILE_DIR);
        File[] saveFiles = profileDirectory.listFiles();
        List<String> profiles = new ArrayList<>();

        try {
            if (saveFiles != null) {
                for (File save : saveFiles) {
                    String[] savePath = save.getAbsolutePath().split("\\.");
                    if (savePath[savePath.length - 1].equals(PROFILE_FILE_EXTENSION) && save.isFile()) {
                        String[] name = save.getName().split("\\.");
                        profiles.add(String.join(".", Arrays.copyOf(name, name.length-1)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return profiles;
    }

    private static List<Profile> getProfiles() {
        List<Profile> profiles = new ArrayList<>();
        for (String name : getProfileNames()) {
            profiles.add(load(name));
        }
        return profiles;
    }

    public static List<Profile> getProfiles(String levelName) {
        List<Profile> profiles = getProfiles();
        List<Profile> returnProfiles = new ArrayList<>();

        for (Profile profile : profiles) {
            if (profile.levelCompleted(levelName)) {
                returnProfiles.add(profile);
            }
        }
        return returnProfiles;
    }
}
