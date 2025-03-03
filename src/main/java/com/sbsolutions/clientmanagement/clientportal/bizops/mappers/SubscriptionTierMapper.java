package com.sbsolutions.clientmanagement.clientportal.bizops.mappers;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.SubscriptionTier;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.SubscriptionTierDTO;

import java.util.stream.Collectors;

public class SubscriptionTierMapper {

    public static SubscriptionTierDTO toDTO(SubscriptionTier subscriptionTier) {
        if (subscriptionTier == null) {
            return null;
        }

        SubscriptionTierDTO dto = new SubscriptionTierDTO();
        dto.setSubscriptionTierId(subscriptionTier.getSubscriptionTierId());
        dto.setTierType(subscriptionTier.getTierType());
        dto.setDescription(subscriptionTier.getDescription());
        dto.setPrice(subscriptionTier.getPrice());

        if (subscriptionTier.getFeatures() != null) {
            dto.setFeaturesList(subscriptionTier.getFeatures()
                    .stream()
                    .map(FeatureMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static SubscriptionTier toEntity(SubscriptionTierDTO dto) {
        if (dto == null) {
            return null;
        }

        SubscriptionTier subscriptionTier = new SubscriptionTier();
        subscriptionTier.setSubscriptionTierId(dto.getSubscriptionTierId());
        subscriptionTier.setTierType(dto.getTierType());
        subscriptionTier.setDescription(dto.getDescription());
        subscriptionTier.setPrice(dto.getPrice());

        if (dto.getFeaturesList() != null) {
            subscriptionTier.setFeatures(dto.getFeaturesList()
                    .stream()
                    .map(FeatureMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        return subscriptionTier;
    }
}
