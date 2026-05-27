package dev.deyve.singleton;

public class Main {

    public static void main(String[] args) {
        var config = AppConfig.getInstance();
        var sameConfig = AppConfig.getInstance();

        System.out.println(config == sameConfig);

        config.set("feature.x", "on");
        System.out.println(sameConfig.get("feature.x"));
        System.out.println(sameConfig.get("env"));
    }
}
