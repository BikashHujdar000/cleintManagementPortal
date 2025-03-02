package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;


import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.DeletionResponse;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.SubscriptionTierDTO;

import java.util.List;

public interface SubscriptionTierService {
    SubscriptionTierDTO createSubscriptionTier(SubscriptionTierDTO subscriptionTierDTO);

    SubscriptionTierDTO updateSubscriptionTier(Long id, SubscriptionTierDTO subscriptionTierDTO);

    SubscriptionTierDTO getSubscriptionTierById(Long id);

    List<SubscriptionTierDTO> getAllSubscriptionTiers();

    DeletionResponse deleteSubscriptionTier(Long id);
}
