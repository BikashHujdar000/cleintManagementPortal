package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.DatabaseConfigurationDTO;

public interface DatabaseConfigurationService {
    DatabaseConfigurationDTO createDatabaseConfiguration(DatabaseConfigurationDTO databaseConfigurationDTO);

    DatabaseConfigurationDTO updateDatabaseConfiguration(Long id, DatabaseConfigurationDTO databaseConfigurationDTO);

    DatabaseConfigurationDTO getDatabaseConfigurationById(Long id);

    void deleteDatabaseConfiguration(Long id);
}
