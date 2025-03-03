package com.sbsolutions.clientmanagement.clientportal.bizops.entities;

import com.sbsolutions.clientmanagement.clientportal.bizops.enums.TierType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class SubscriptionTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionTierId;

    @Enumerated(EnumType.STRING)
    private TierType tierType;

    private String description;

    private BigDecimal price;

    @OneToMany(mappedBy = "subscriptionTier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feature> features;

}
