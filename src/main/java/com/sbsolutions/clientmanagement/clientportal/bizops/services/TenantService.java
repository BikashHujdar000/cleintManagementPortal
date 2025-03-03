package com.sbsolutions.clientmanagement.clientportal.bizops.services;



import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Tenant;
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


    Page<TenantDTO> getAll(Pageable pageable);
}
