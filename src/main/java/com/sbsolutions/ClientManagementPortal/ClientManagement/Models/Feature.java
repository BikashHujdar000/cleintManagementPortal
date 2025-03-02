package com.sbsolutions.ClientManagementPortal.ClientManagement.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;

    private String name;
    private String description;
    private boolean isPremium;

    @ManyToOne
    @JoinColumn(name = "subscription_tier_id")
    private SubscriptionTier subscriptionTier;

}
