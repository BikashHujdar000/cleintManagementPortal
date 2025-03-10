package com.sbsolutions.clientmanagement.clientportal.bizops.entities;

import com.sbsolutions.clientmanagement.clientportal.bizops.enums.PlanType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false, unique = true)
    private String organizationSwiftcode;

    @Column(nullable = false, unique = true)
    private String organizationEmail;

    @Column(nullable = false, unique = true)
    private String subDomainName;

    private LocalDateTime createdDate;

    private LocalDateTime expirationDate;

    private boolean active = false;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private String   schemaName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanType planType;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_configuration_id")
    private AdminConfiguration adminConfiguration;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_configuration_id")
    private ThemeConfiguration themeConfiguration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_tier_id")
    private SubscriptionTier subscriptionTier;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_address_id")
    private OrganizationAddress organizationAddress;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "database_configuration_id")
    private DatabaseConfiguration databaseConfiguration;
}
