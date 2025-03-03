package com.sbsolutions.clientmanagement.clientportal.web.api.internal.controllers;


import com.sbsolutions.clientmanagement.Global.GlobalResponse.RestResponse;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.TenantService;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.TenantDTO;
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
    public ResponseEntity<?> createTenant(@RequestBody TenantDTO tenantDTO) {
        TenantDTO savedTenant = this.tenantService.createTenant(tenantDTO);
         return new RestResponse<>().createdStatusWithPayload(savedTenant,"Tenant Created Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllTenants() {
        List<TenantDTO> tenants = this.tenantService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    @GetMapping("/{tenantId}")
    public ResponseEntity<?> getTenantById(@PathVariable Long tenantId) {
        TenantDTO tenant = this.tenantService.getTenantById(tenantId);
      return  new RestResponse<>().oKWithPayload(tenant,"Tenant Retrieved Successfully");
    }


    @PutMapping("/{tenantId}")
    public ResponseEntity<?> updateTenant(@PathVariable Long tenantId, @RequestBody TenantDTO tenantDTO) {
        TenantDTO updatedTenant =this.tenantService.updateTenant(tenantId, tenantDTO);
        return new RestResponse<>().createdStatusWithPayload(updatedTenant,"Tenant Created Successfully");
    }
    @DeleteMapping("/{tenantId}")
    public  ResponseEntity<?> deleteTenant(@PathVariable("tenantId") Long tenantId) {
        DeletionResponse response =  this.tenantService.deleteTenant(tenantId);
        return  new RestResponse<>().oKWithPayload(response,"Tenant Deleted Successfully");
    }


}
