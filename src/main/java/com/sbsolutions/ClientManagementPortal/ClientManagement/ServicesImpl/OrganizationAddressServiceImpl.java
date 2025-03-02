package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.OrganizationAddressDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.OrganizationAddressMapper;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.OrganizationAddress;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.OrganizationAddressRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.OrganizationAddressService;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.DatabaseOperationException;
import org.springframework.stereotype.Service;

@Service
public class OrganizationAddressServiceImpl implements OrganizationAddressService {
    private final OrganizationAddressRepository organizationAddressRepository;

    public OrganizationAddressServiceImpl(OrganizationAddressRepository organizationAddressRepository) {
        this.organizationAddressRepository = organizationAddressRepository;
    }

    @Override
    public OrganizationAddressDTO createOrganizationAddress(OrganizationAddressDTO organizationAddressDTO) {

        try {
            OrganizationAddress organizationAddress = OrganizationAddressMapper.toEntity(organizationAddressDTO);
            OrganizationAddress savedorganizationAddress = organizationAddressRepository.save(organizationAddress);
            return OrganizationAddressMapper.toDTO(savedorganizationAddress);

        } catch (Exception e) {
            throw new DatabaseOperationException("Failed to create organization address");
        }
    }

    @Override
    public OrganizationAddressDTO updateOrganizationAddress(Long id, OrganizationAddressDTO organizationAddressDTO) {
        return null;
    }

    @Override
    public OrganizationAddressDTO getOrganizationAddressById(Long id) {
        return null;
    }

    @Override
    public void deleteOrganizationAddress(Long id) {

    }
}
