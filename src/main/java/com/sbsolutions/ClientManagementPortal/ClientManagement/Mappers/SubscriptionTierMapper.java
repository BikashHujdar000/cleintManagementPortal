package com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.SubscriptionTierDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.SubscriptionTier;
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
