package dev.deyve.singleton;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {

    private static AppConfig instance;

    private final Map<String, String> settings = new HashMap<>();

    private AppConfig() {
        settings.put("env", "dev");
        settings.put("version", "1.0");
    }

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String get(String key) {
        return settings.get(key);
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }
}
