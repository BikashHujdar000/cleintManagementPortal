package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.OrganizationAddressDTO;

public interface OrganizationAddressService {
    OrganizationAddressDTO createOrganizationAddress(OrganizationAddressDTO organizationAddressDTO);

    OrganizationAddressDTO updateOrganizationAddress(Long id, OrganizationAddressDTO organizationAddressDTO);

    OrganizationAddressDTO getOrganizationAddressById(Long id);

    void deleteOrganizationAddress(Long id);
}
