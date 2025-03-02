package com.sbsolutions.ClientManagementPortal.ClientManagement.Controllers;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.TenantDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.TenantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }


    @PostMapping
    public ResponseEntity<TenantDTO> createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantDTO savedTenant = tenantService.createTenant(tenantDTO);
        return ResponseEntity.status(201).body(savedTenant);
    }

    @GetMapping
    public ResponseEntity<List<TenantDTO>> getAllTenants() {
        List<TenantDTO> tenants = tenantService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    // ✅ Get a specific tenant by ID
    @GetMapping("/{tenantId}")
    public ResponseEntity<TenantDTO> getTenantById(@PathVariable Long tenantId) {
        TenantDTO tenant = tenantService.getTenantById(tenantId);
        return ResponseEntity.ok(tenant);
    }

    // ✅ Update an existing tenant
    @PutMapping("/{tenantId}")
    public ResponseEntity<TenantDTO> updateTenant(@PathVariable Long tenantId, @RequestBody TenantDTO tenantDTO) {
        TenantDTO updatedTenant = tenantService.updateTenant(tenantId, tenantDTO);
        return ResponseEntity.ok(updatedTenant);
    }

    // ✅ Delete a tenant
    @DeleteMapping("/{tenantId}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long tenantId) {
        tenantService.deleteTenant(tenantId);
        return ResponseEntity.noContent().build();
    }
}
