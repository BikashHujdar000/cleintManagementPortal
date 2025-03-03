package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.SubscriptionTierDTO;

import java.util.List;

public interface SubscriptionTierService {
    SubscriptionTierDTO createSubscriptionTier(SubscriptionTierDTO subscriptionTierDTO);

    SubscriptionTierDTO updateSubscriptionTier(Long id, SubscriptionTierDTO subscriptionTierDTO);

    SubscriptionTierDTO getSubscriptionTierById(Long id);

    List<SubscriptionTierDTO> getAllSubscriptionTiers();

    DeletionResponse deleteSubscriptionTier(Long id);
}
