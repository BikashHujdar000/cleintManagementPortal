package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.AdminConfigurationDTO;

public interface AdminConfigurationService {
    AdminConfigurationDTO createAdminConfiguration(AdminConfigurationDTO adminConfigurationDTO);

    AdminConfigurationDTO updateAdminConfiguration(Long id, AdminConfigurationDTO adminConfigurationDTO);

    AdminConfigurationDTO getAdminConfigurationById(Long id);

    void deleteAdminConfiguration(Long id);
}
