package dev.deyve.chainresponsability;

public class Authenticator extends Handler {

    public Authenticator(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        var isValid = (request.getUsername().equals("admin") && request.getPassword().equals("1234"));

        System.out.println("Authentication");

        return !isValid;
    }
}
