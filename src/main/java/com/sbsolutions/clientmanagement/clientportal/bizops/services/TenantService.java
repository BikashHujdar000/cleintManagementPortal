package com.sbsolutions.clientmanagement.clientportal.bizops.services;



import ch.qos.logback.core.net.server.Client;
import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.Clients;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.TenantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TenantService {
    TenantDTO createTenant(TenantDTO tenantDTO);

    TenantDTO updateTenant(Long tenantId, TenantDTO tenantDTO);

    TenantDTO getTenantById(Long tenantId);

    List<TenantDTO> getAllTenants();

    DeletionResponse deleteTenant(Long tenantId);


    List<Clients> getAllClients();

    Page<TenantDTO> getAll(Pageable pageable);

    boolean phoneNumberExists(String phoneNumber);


    boolean organizationEmailExists(String organizationEmail);


    boolean subDomainNameExists(String subDomainName);


    boolean organizationSwiftcodeExists(String organizationSwiftcode);

}
