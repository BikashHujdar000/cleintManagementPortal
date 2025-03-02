package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;


import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.DatabaseConfigurationDTO;

public interface DatabaseConfigurationService {
    DatabaseConfigurationDTO createDatabaseConfiguration(DatabaseConfigurationDTO databaseConfigurationDTO);

    DatabaseConfigurationDTO updateDatabaseConfiguration(Long id, DatabaseConfigurationDTO databaseConfigurationDTO);

    DatabaseConfigurationDTO getDatabaseConfigurationById(Long id);

    void deleteDatabaseConfiguration(Long id);
}
