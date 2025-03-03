package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import com.sbsolutions.clientmanagement.clientportal.bizops.enums.TierType;
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
