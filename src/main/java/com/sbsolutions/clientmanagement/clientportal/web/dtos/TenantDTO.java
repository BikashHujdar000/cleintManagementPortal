package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import com.sbsolutions.clientmanagement.clientportal.bizops.enums.PlanType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TenantDTO {
    private Long tenantId;
    private String organizationName;
    private String organizationSwiftcode;
    private String organizationEmail;
    private String subDomainName;
    private String  schemaName;
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private boolean active;
    private String phoneNumber;
    private PlanType planType;
    private AdminConfigurationDTO adminConfiguration;
    private ThemeConfigurationDTO themeConfiguration;
    private SubscriptionTierDTO subscriptionTier;
    private OrganizationAddressDTO organizationAddress;
    private DatabaseConfigurationDTO databaseConfiguration;
}
