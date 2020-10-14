package com.kenez92;

public final class SettingsFileEngine {
    private static SettingsFileEngine settingsFileInstance = null;
    private String fileName = "";

    private SettingsFileEngine() {
    }

    public static SettingsFileEngine getInstance() {
        if (settingsFileInstance == null) {
            synchronized (SettingsFileEngine.class) {
                if (settingsFileInstance == null) {
                    settingsFileInstance = new SettingsFileEngine();
                }
            }
        }
        return settingsFileInstance;
    }

    public String getFiLeName() {
        return fileName;
    }

    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settings file");
    }

    public void close() {
        this.fileName = "";
        System.out.println("Closing the setting file");
    }

    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
