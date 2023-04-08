package dev.deyve.chainresponsability;

public class Logger extends Handler {

    public Logger(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean doHandle(HttpRequest request) {

        System.out.println("Log");

        return false;
    }
}
