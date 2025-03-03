package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.DatabaseConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseConfigurationRepository extends JpaRepository<DatabaseConfiguration, Long> {
}
