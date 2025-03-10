package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import com.sbsolutions.clientmanagement.clientportal.bizops.enums.PlanType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TenantDTO {

    private Long tenantId;

    @NotBlank(message = "Organization name is required")
    @Size(min = 3, max = 100, message = "Organization name must be between 3 and 100 characters")
    private String organizationName;

    @NotBlank(message = "Swift code is required")
    @Size(min = 3, max = 11, message = "Swift code must be between 8 and 11 characters")
    private String organizationSwiftcode;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String organizationEmail;

    @NotBlank(message = "Subdomain name is required")
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "Subdomain can only contain letters, numbers, and hyphens")
    private String subDomainName;


    private String schemaName;

    @PastOrPresent(message = "Created date must be in the past or present")
    private LocalDateTime createdDate;

    @NotNull(message = "Expiration date is required")
    private LocalDateTime expirationDate;

    private boolean active;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Plan type is required")
    private PlanType planType;

    @NotNull(message = "Admin configuration is required")
    private AdminConfigurationDTO adminConfiguration;

    @NotNull(message = "Theme configuration is required")
    private ThemeConfigurationDTO themeConfiguration;

    @NotNull(message = "Subscription tier is required")
    private SubscriptionTierDTO subscriptionTier;

    @NotNull(message = "Organization address is required")
    private OrganizationAddressDTO organizationAddress;

    @NotNull(message = "Database configuration is required")
    private DatabaseConfigurationDTO databaseConfiguration;

}
