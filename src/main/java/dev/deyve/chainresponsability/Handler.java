package dev.deyve.chainresponsability;

public abstract class Handler {

    private final Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(HttpRequest request) {
        if (doHandle(request)) {
            return;
        }

        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    public abstract boolean doHandle(HttpRequest request);

}
