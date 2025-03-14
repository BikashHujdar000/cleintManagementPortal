package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.DatabaseConfiguration;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DatabaseConfigurationDTO;

public class DatabaseConfigurationMapper {
    public static DatabaseConfigurationDTO toDTO(DatabaseConfiguration entity) {
        if (entity == null) {
            return null;
        }
        DatabaseConfigurationDTO dto = new DatabaseConfigurationDTO();
        dto.setDatabaseConfigurationId(entity.getDatabaseConfigurationId());
        dto.setDbName(entity.getDbName());
        dto.setDbUrl(entity.getDbUrl());
        dto.setDbCredentialUsername(entity.getDbCredentialUsername());
        dto.setDbCredentialPassword(entity.getDbCredentialPassword());
        return dto;
    }

    public static DatabaseConfiguration toEntity(DatabaseConfigurationDTO dto) {
        if (dto == null) {
            return null;
        }
        DatabaseConfiguration entity = new DatabaseConfiguration();
        entity.setDatabaseConfigurationId(dto.getDatabaseConfigurationId());
        entity.setDbName(dto.getDbName());
        entity.setDbUrl(dto.getDbUrl());
        entity.setDbCredentialUsername(dto.getDbCredentialUsername());
        entity.setDbCredentialPassword(dto.getDbCredentialPassword());
        return entity;
    }
}
