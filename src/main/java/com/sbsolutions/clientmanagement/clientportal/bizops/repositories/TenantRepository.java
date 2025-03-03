package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
