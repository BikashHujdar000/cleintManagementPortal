package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    Optional<Tenant> findByPhoneNumber(String phoneNumber);

    Optional<Tenant> findByOrganizationEmail(String organizationEmail);

    Optional<Tenant> findBySubDomainName(String subDomainName);

    Optional<Tenant> findByOrganizationSwiftcode(String organizationSwiftcode);
}
