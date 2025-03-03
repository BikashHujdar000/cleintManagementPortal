package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.OrganizationAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress, Long> {
}
