package com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.ThemeConfigurationDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.ThemeConfiguration;

public class ThemeConfigurationMapper {
    public static ThemeConfigurationDTO toDTO(ThemeConfiguration entity) {
        if (entity == null) {
            return null;
        }
        ThemeConfigurationDTO dto = new ThemeConfigurationDTO();
        dto.setThemeConfigurationId(entity.getThemeConfigurationId());
        dto.setPrimaryColor(entity.getPrimaryColor());
        dto.setSecondaryColor(entity.getSecondaryColor());
        dto.setLogoUrl(entity.getLogoUrl());
        dto.setFaviconUrl(entity.getFaviconUrl());
        return dto;
    }

    public static ThemeConfiguration toEntity(ThemeConfigurationDTO dto) {
        if (dto == null) {
            return null;
        }
        ThemeConfiguration entity = new ThemeConfiguration();
        entity.setThemeConfigurationId(dto.getThemeConfigurationId());
        entity.setPrimaryColor(dto.getPrimaryColor());
        entity.setSecondaryColor(dto.getSecondaryColor());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setFaviconUrl(dto.getFaviconUrl());
        return entity;
    }
}
