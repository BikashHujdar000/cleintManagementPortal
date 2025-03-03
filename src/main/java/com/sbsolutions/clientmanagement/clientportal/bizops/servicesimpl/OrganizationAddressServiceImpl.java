package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;


import com.sbsolutions.clientmanagement.clientportal.bizops.entities.OrganizationAddress;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.OrganizationAddressMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.OrganizationAddressRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.OrganizationAddressService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.OrganizationAddressDTO;
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
            throw new DatabaseOperationException("Failed to create organization address: "+e.getMessage());
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
