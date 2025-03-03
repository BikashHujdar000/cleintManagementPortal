package com.sbsolutions.clientmanagement.clientportal.web.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationAddressDTO {
    private Long addressId;
    private String country;
    private String district;
    private String city;
    private String addressLine1;
    private String addressLine2;
}
