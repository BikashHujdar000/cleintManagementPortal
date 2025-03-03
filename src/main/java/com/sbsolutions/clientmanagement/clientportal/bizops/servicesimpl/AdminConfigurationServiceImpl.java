package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.AdminConfiguration;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.AdminConfigurationMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.AdminConfigurationRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.AdminConfigurationService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.AdminConfigurationDTO;
import org.springframework.stereotype.Service;

@Service
public class AdminConfigurationServiceImpl implements AdminConfigurationService {
    private  final AdminConfigurationRepository adminConfigurationRepository;

    public AdminConfigurationServiceImpl(AdminConfigurationRepository adminConfigurationRepository) {
        this.adminConfigurationRepository = adminConfigurationRepository;
    }

    @Override
    public AdminConfigurationDTO createAdminConfiguration(AdminConfigurationDTO adminConfigurationDTO) {
        try {
            AdminConfiguration adminConfiguration = AdminConfigurationMapper.toEntity(adminConfigurationDTO);
            AdminConfiguration savedAdminConfiguration = adminConfigurationRepository.save(adminConfiguration);
            return AdminConfigurationMapper.toDTO(savedAdminConfiguration);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while saving feature: " + e.getMessage());
        }
    }

    @Override
    public AdminConfigurationDTO updateAdminConfiguration(Long id, AdminConfigurationDTO adminConfigurationDTO) {
        return null;
    }

    @Override
    public AdminConfigurationDTO getAdminConfigurationById(Long id) {
        return null;
    }

    @Override
    public void deleteAdminConfiguration(Long id) {

    }
}
