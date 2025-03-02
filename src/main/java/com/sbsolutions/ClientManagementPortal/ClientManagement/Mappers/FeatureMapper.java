package com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.FeatureDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.Feature;


public class FeatureMapper {

    private FeatureMapper() {
    }
    public static FeatureDTO toDTO(Feature feature) {
        FeatureDTO dto = new FeatureDTO();
        dto.setFeatureId(feature.getFeatureId());
        dto.setName(feature.getName());
        dto.setDescription(feature.getDescription());
        dto.setPremium(feature.isPremium());
        return dto;
    }

    public static Feature toEntity(FeatureDTO dto) {
        Feature feature = new Feature();
        feature.setFeatureId(dto.getFeatureId());
        feature.setName(dto.getName());
        feature.setDescription(dto.getDescription());
        feature.setPremium(dto.isPremium());
        return feature;
    }
}
