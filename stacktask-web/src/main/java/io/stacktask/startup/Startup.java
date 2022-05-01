package io.stacktask.startup;

import io.stacktask.entity.OrganizationEntity;
import io.stacktask.entity.User;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {
    @Transactional
    public void createUsers(@Observes StartupEvent event) {
        User.deleteAll();
        User user = User.add("user", "user", "user");
        OrganizationEntity.deleteAll();
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.owner = user;
        organizationEntity.name = "My First Organization";
        organizationEntity.persist();
    }
}
