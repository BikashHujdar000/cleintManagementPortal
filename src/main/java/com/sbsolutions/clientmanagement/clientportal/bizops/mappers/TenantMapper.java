package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.TenantDTO;

public class TenantMapper {

    public static TenantDTO toDTO(Tenant entity) {
        if (entity == null) {
            return null;
        }
        TenantDTO dto = new TenantDTO();
        dto.setTenantId(entity.getTenantId());
        dto.setOrganizationName(entity.getOrganizationName());
        dto.setOrganizationSwiftcode(entity.getOrganizationSwiftcode());
        dto.setOrganizationEmail(entity.getOrganizationEmail());
        dto.setSubDomainName(entity.getSubDomainName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setActive(entity.isActive());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setPlanType(entity.getPlanType());

        // Mapping associated configurations
        dto.setAdminConfiguration(AdminConfigurationMapper.toDTO(entity.getAdminConfiguration()));
        dto.setThemeConfiguration(ThemeConfigurationMapper.toDTO(entity.getThemeConfiguration()));
        dto.setSubscriptionTier(SubscriptionTierMapper.toDTO(entity.getSubscriptionTier()));
        dto.setOrganizationAddress(OrganizationAddressMapper.toDTO(entity.getOrganizationAddress()));
        dto.setDatabaseConfiguration(DatabaseConfigurationMapper.toDTO(entity.getDatabaseConfiguration()));

        return dto;
    }

    public static Tenant toEntity(TenantDTO dto) {
        if (dto == null) {
            return null;
        }
        Tenant entity = new Tenant();
        entity.setTenantId(dto.getTenantId());
        entity.setOrganizationName(dto.getOrganizationName());
        entity.setOrganizationSwiftcode(dto.getOrganizationSwiftcode());
        entity.setOrganizationEmail(dto.getOrganizationEmail());
        entity.setSubDomainName(dto.getSubDomainName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setExpirationDate(dto.getExpirationDate());
        entity.setActive(dto.isActive());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPlanType(dto.getPlanType());

        // Mapping associated configurations
        entity.setAdminConfiguration(AdminConfigurationMapper.toEntity(dto.getAdminConfiguration()));
        entity.setThemeConfiguration(ThemeConfigurationMapper.toEntity(dto.getThemeConfiguration()));
        entity.setSubscriptionTier(SubscriptionTierMapper.toEntity(dto.getSubscriptionTier()));
        entity.setOrganizationAddress(OrganizationAddressMapper.toEntity(dto.getOrganizationAddress()));
        entity.setDatabaseConfiguration(DatabaseConfigurationMapper.toEntity(dto.getDatabaseConfiguration()));

        return entity;
    }
}
