package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.AdminConfigurationDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.AdminConfigurationMapper;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.AdminConfiguration;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.AdminConfigurationRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.AdminConfigurationService;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.DatabaseOperationException;
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
