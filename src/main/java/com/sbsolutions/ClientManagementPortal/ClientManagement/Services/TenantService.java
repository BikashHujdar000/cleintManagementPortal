package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;


import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.TenantDTO;
import java.util.List;

public interface TenantService {
    TenantDTO createTenant(TenantDTO tenantDTO);

    TenantDTO updateTenant(Long tenantId, TenantDTO tenantDTO);

    TenantDTO getTenantById(Long tenantId);

    List<TenantDTO> getAllTenants();

    void deleteTenant(Long tenantId);
}
