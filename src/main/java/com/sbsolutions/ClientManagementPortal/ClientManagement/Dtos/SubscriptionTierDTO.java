package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Enums.TierType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SubscriptionTierDTO {
    private Long subscriptionTierId;
    private TierType tierType;
    private String description;
    private BigDecimal price;
    private List<FeatureDTO> featuresList;
}
