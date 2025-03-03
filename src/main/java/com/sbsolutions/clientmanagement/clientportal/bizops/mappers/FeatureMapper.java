package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Feature;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.FeatureDTO;


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
