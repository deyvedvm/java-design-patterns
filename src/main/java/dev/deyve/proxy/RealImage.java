package dev.deyve.proxy;

public class RealImage implements Image {

    private static int loadCount;

    private final String path;

    public RealImage(String path) {
        this.path = path;
        loadFromDisk();
    }

    private void loadFromDisk() {
        loadCount++;
    }

    @Override
    public void display() {
        // would render to screen — no-op for the demo
    }

    public String getPath() {
        return path;
    }

    public static int getLoadCount() {
        return loadCount;
    }

    public static void resetLoadCount() {
        loadCount = 0;
    }
}
