package io.stacktask.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.stacktask.view.UserViews;

import javax.persistence.*;

@Entity
@UserDefinition
public class User extends PanacheEntity {
    @Username
    @JsonView(UserViews.Public.class)
    public String username;

    @Password
    @JsonView(UserViews.Blocked.class)
    public String password;

    @Roles
    @JsonView(UserViews.Blocked.class)
    public String role;

    public static User add(String username, String password, String role) {
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
        return user;
    }
}
