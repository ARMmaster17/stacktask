package io.stacktask.service;

import io.stacktask.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
    public User getUser(String username) {
        return User.find("username", username).firstResult();
    }
}
