package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatureDTO {
    private Long featureId;
    private String name;
    private String description;
    private boolean isPremium;
}
