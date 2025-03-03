package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.DatabaseConfiguration;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.DatabaseConfigurationMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.DatabaseConfigurationRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.DatabaseConfigurationService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DatabaseConfigurationDTO;
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
            throw new DatabaseOperationException("Failed to save database configuration :"+e.getMessage());
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
