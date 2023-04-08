package dev.deyve.chainresponsability;

public class WebServer {

    private final Handler handler;

    public WebServer(Handler handler) {
        this.handler = handler;
    }

    public void handle(HttpRequest request) {
        handler.handle(request);
    }
}
