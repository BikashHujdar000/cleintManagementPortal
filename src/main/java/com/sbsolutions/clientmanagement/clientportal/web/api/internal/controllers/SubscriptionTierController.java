package com.sbsolutions.clientmanagement.clientportal.web.api.internal.controllers;

import com.sbsolutions.clientmanagement.clientportal.bizops.services.SubscriptionTierService;
import com.sbsolutions.clientmanagement.Global.GlobalResponse.RestResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.SubscriptionTierDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subscription-tiers")  // ✅ Plural naming for consistency
public class SubscriptionTierController {

    private final SubscriptionTierService subscriptionTierService;

    public SubscriptionTierController(SubscriptionTierService subscriptionTierService) {
        this.subscriptionTierService = subscriptionTierService;
    }

    @PostMapping
    public ResponseEntity<?> createSubscriptionTier(@RequestBody SubscriptionTierDTO subscriptionTierDTO) {
        SubscriptionTierDTO createdSubscriptionTier = subscriptionTierService.createSubscriptionTier(subscriptionTierDTO);
        return new RestResponse<>().createdStatusWithPayload(createdSubscriptionTier, "Subscription Tier created successfully");
    }

    @GetMapping("/{subscriptionTierId}")
    public ResponseEntity<?> getSubscriptionTierById(@PathVariable Long subscriptionTierId) {
        SubscriptionTierDTO subscriptionTierDTO = subscriptionTierService.getSubscriptionTierById(subscriptionTierId);
        return new RestResponse<>().oKWithPayload(subscriptionTierDTO, "Subscription Tier retrieved successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllSubscriptionTiers() {
        List<SubscriptionTierDTO> subscriptionTiers = subscriptionTierService.getAllSubscriptionTiers();
        return new RestResponse<>().oKWithPayload(subscriptionTiers, "All Subscription Tiers retrieved successfully");
    }

    @PutMapping("/{subscriptionTierId}")
    public ResponseEntity<?> updateSubscriptionTier(@PathVariable Long subscriptionTierId, @RequestBody SubscriptionTierDTO subscriptionTierDTO) {
        SubscriptionTierDTO updatedSubscriptionTier = subscriptionTierService.updateSubscriptionTier(subscriptionTierId, subscriptionTierDTO);
        return new RestResponse<>().createdStatusWithPayload(updatedSubscriptionTier, "Subscription Tier updated successfully");
    }

    @DeleteMapping("/{subscriptionTierId}")
    public ResponseEntity<?> deleteSubscriptionTier(@PathVariable Long subscriptionTierId) {
        DeletionResponse response =  subscriptionTierService.deleteSubscriptionTier(subscriptionTierId);
        return new RestResponse<>().oKWithPayload(response, "Feature deleted successfully");
    }
}
