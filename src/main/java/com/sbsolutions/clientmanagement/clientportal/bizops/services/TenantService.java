package com.sbsolutions.clientmanagement.clientportal.bizops.services;



import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.TenantDTO;

import java.util.List;

public interface TenantService {
    TenantDTO createTenant(TenantDTO tenantDTO);

    TenantDTO updateTenant(Long tenantId, TenantDTO tenantDTO);

    TenantDTO getTenantById(Long tenantId);

    List<TenantDTO> getAllTenants();

    DeletionResponse deleteTenant(Long tenantId);
}
