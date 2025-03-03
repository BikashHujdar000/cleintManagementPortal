package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.ThemeConfiguration;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.ThemeConfigurationMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.ThemeConfigurationRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.ThemeConfigurationService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.ThemeConfigurationDTO;
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
