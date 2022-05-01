package io.stacktask.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.stacktask.view.UserViews;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "organization_entity")
public class OrganizationEntity extends PanacheEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    public User owner;

    @NotNull
    public String name;
}