package com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
