package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.ThemeConfigurationDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.ThemeConfigurationMapper;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.ThemeConfiguration;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.ThemeConfigurationRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.ThemeConfigurationService;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.DatabaseOperationException;
import org.springframework.stereotype.Service;

@Service
public class ThemeConfigurationServiceImpl implements ThemeConfigurationService {
    private final ThemeConfigurationRepository themeConfigurationRepository;

    public ThemeConfigurationServiceImpl(ThemeConfigurationRepository themeConfigurationRepository) {
        this.themeConfigurationRepository = themeConfigurationRepository;
    }

    @Override
    public ThemeConfigurationDTO createThemeConfiguration(ThemeConfigurationDTO themeConfigurationDTO) {
        try {
            ThemeConfiguration themeConfiguration = ThemeConfigurationMapper.toEntity(themeConfigurationDTO);
            ThemeConfiguration savedThemeConfiguration = this.themeConfigurationRepository.save(themeConfiguration);
            return ThemeConfigurationMapper.toDTO(savedThemeConfiguration);
        } catch (Exception ex) {
            throw new DatabaseOperationException("Failed to create theme configuration");
        }

    }

    @Override
    public ThemeConfigurationDTO updateThemeConfiguration(Long id, ThemeConfigurationDTO themeConfigurationDTO) {
        return null;
    }

    @Override
    public ThemeConfigurationDTO getThemeConfigurationById(Long id) {
        return null;
    }

    @Override
    public void deleteThemeConfiguration(Long id) {

    }
}
