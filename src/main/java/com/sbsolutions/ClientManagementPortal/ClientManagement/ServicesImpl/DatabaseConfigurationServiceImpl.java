package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.DatabaseConfigurationDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.DatabaseConfigurationMapper;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.DatabaseConfiguration;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.DatabaseConfigurationRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.DatabaseConfigurationService;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.DatabaseOperationException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConfigurationServiceImpl  implements DatabaseConfigurationService {
    private final  DatabaseConfigurationRepository databaseConfigurationRepository;

    public DatabaseConfigurationServiceImpl(DatabaseConfigurationRepository databaseConfigurationRepository) {
        this.databaseConfigurationRepository = databaseConfigurationRepository;
    }

    @Override
    public DatabaseConfigurationDTO createDatabaseConfiguration(DatabaseConfigurationDTO databaseConfigurationDTO) {
        try
        {
            DatabaseConfiguration databaseConfiguration = DatabaseConfigurationMapper.toEntity(databaseConfigurationDTO);
            DatabaseConfiguration savedDatabaseConfiguration = databaseConfigurationRepository.save(databaseConfiguration);
            return DatabaseConfigurationMapper.toDTO(savedDatabaseConfiguration);

        }catch (Exception e){
            throw new DatabaseOperationException("Failed to save database configuration");
        }

    }

    @Override
    public DatabaseConfigurationDTO updateDatabaseConfiguration(Long id, DatabaseConfigurationDTO databaseConfigurationDTO) {
        return null;
    }

    @Override
    public DatabaseConfigurationDTO getDatabaseConfigurationById(Long id) {
        return null;
    }

    @Override
    public void deleteDatabaseConfiguration(Long id) {

    }
}
