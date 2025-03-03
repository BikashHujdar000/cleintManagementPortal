package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.ThemeConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeConfigurationRepository extends JpaRepository<ThemeConfiguration, Long> {
}
