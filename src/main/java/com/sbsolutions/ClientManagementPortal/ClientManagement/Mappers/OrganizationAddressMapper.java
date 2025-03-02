package com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.OrganizationAddressDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.OrganizationAddress;

public class OrganizationAddressMapper {
    public static OrganizationAddressDTO toDTO(OrganizationAddress entity) {
        if (entity == null) {
            return null;
        }
        OrganizationAddressDTO dto = new OrganizationAddressDTO();
        dto.setAddressId(entity.getAddressId());
        dto.setCountry(entity.getCountry());
        dto.setDistrict(entity.getDistrict());
        dto.setCity(entity.getCity());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setAddressLine2(entity.getAddressLine2());
        return dto;
    }

    public static OrganizationAddress toEntity(OrganizationAddressDTO dto) {
        if (dto == null) {
            return null;
        }
        OrganizationAddress entity = new OrganizationAddress();
        entity.setAddressId(dto.getAddressId());
        entity.setCountry(dto.getCountry());
        entity.setDistrict(dto.getDistrict());
        entity.setCity(dto.getCity());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setAddressLine2(dto.getAddressLine2());
        return entity;
    }
}
