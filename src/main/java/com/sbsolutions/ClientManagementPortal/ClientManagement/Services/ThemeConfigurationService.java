package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.ThemeConfigurationDTO;

public interface ThemeConfigurationService {
    ThemeConfigurationDTO createThemeConfiguration(ThemeConfigurationDTO themeConfigurationDTO);

    ThemeConfigurationDTO updateThemeConfiguration(Long id, ThemeConfigurationDTO themeConfigurationDTO);

    ThemeConfigurationDTO getThemeConfigurationById(Long id);

    void deleteThemeConfiguration(Long id);
}
