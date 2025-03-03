package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.ThemeConfigurationDTO;

public interface ThemeConfigurationService {
    ThemeConfigurationDTO createThemeConfiguration(ThemeConfigurationDTO themeConfigurationDTO);

    ThemeConfigurationDTO updateThemeConfiguration(Long id, ThemeConfigurationDTO themeConfigurationDTO);

    ThemeConfigurationDTO getThemeConfigurationById(Long id);

    void deleteThemeConfiguration(Long id);
}
