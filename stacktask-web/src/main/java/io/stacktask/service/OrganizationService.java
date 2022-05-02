package io.stacktask.service;

import io.stacktask.entity.OrganizationEntity;
import io.stacktask.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class OrganizationService {
    public List<OrganizationEntity> findUserOrganizations(User user) {
        return OrganizationEntity.listAll();
    }

    public OrganizationEntity persistOrganization(@Valid OrganizationEntity organizationEntity) {
        organizationEntity.persist();
        return organizationEntity;
    }

    public OrganizationEntity updateOrganizationEntity(@Valid OrganizationEntity organizationEntity) {
        OrganizationEntity entity = OrganizationEntity.findById(organizationEntity.id);
        entity.name = organizationEntity.name;
        return entity;
    }
}
