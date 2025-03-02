package com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.ThemeConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeConfigurationRepository extends JpaRepository<ThemeConfiguration, Long> {
}
