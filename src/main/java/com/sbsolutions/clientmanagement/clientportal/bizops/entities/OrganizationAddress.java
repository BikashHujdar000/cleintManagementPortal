package com.sbsolutions.clientmanagement.clientportal.bizops.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class OrganizationAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String country;
    private String district;
    private String city;
    private String addressLine1;
    private String addressLine2;
}
