package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.AdminConfiguration;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.AdminConfigurationDTO;

public class AdminConfigurationMapper {
    public static AdminConfigurationDTO toDTO(AdminConfiguration entity) {
        if (entity == null) {
            return null;
        }
        AdminConfigurationDTO dto = new AdminConfigurationDTO();
        dto.setAdminConfigurationId(entity.getAdminConfigurationId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static AdminConfiguration toEntity(AdminConfigurationDTO dto) {
        if (dto == null) {
            return null;
        }
        AdminConfiguration entity = new AdminConfiguration();
        entity.setAdminConfigurationId(dto.getAdminConfigurationId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
