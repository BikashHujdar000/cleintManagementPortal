package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.OrganizationAddressDTO;

public interface OrganizationAddressService {
    OrganizationAddressDTO createOrganizationAddress(OrganizationAddressDTO organizationAddressDTO);

    OrganizationAddressDTO updateOrganizationAddress(Long id, OrganizationAddressDTO organizationAddressDTO);

    OrganizationAddressDTO getOrganizationAddressById(Long id);

    void deleteOrganizationAddress(Long id);
}
