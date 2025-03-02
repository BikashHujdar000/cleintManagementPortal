package com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.DatabaseConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseConfigurationRepository extends JpaRepository<DatabaseConfiguration, Long> {
}
