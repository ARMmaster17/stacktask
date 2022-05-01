package io.stacktask.model;

public class AuthenticationStateModel {
    private boolean isAuthenticated;

    public AuthenticationStateModel() {

    }

    public AuthenticationStateModel(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }


    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }
}
