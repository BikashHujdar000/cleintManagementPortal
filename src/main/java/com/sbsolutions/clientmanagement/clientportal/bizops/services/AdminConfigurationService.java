package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.AdminConfigurationDTO;

public interface AdminConfigurationService {
    AdminConfigurationDTO createAdminConfiguration(AdminConfigurationDTO adminConfigurationDTO);

    AdminConfigurationDTO updateAdminConfiguration(Long id, AdminConfigurationDTO adminConfigurationDTO);

    AdminConfigurationDTO getAdminConfigurationById(Long id);

    void deleteAdminConfiguration(Long id);
}
