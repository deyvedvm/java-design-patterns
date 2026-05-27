package dev.deyve.proxy;

public class LazyImageProxy implements Image {

    private final String path;
    private RealImage real;

    public LazyImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if (real == null) {
            real = new RealImage(path);
        }
        real.display();
    }

    public boolean isLoaded() {
        return real != null;
    }
}
