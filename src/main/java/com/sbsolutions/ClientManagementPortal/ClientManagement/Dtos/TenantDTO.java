package com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Enums.PlanType;
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
