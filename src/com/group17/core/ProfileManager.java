package com.group17.core;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProfileManager {
    private static final String PROFILE_DIR = "./res/profiles";
    private static final String PROFILE_FILE_EXTENSION = "save";

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
            FileOutputStream file = new FileOutputStream(PROFILE_DIR + "/" + profile.getName() + "." + PROFILE_FILE_EXTENSION);
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

    public static List<Profile> getProfiles() {
        List<Profile> profiles = new ArrayList<>();
        for (String name : getProfileNames()) {
            profiles.add(load(name));
        }
        Collections.sort(profiles);
        return profiles;
    }
}
