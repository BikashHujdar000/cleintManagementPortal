package com.sbsolutions.ClientManagementPortal.ClientManagement.ServicesImpl;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.DeletionResponse;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.FeatureDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.SubscriptionTierDTO;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Mappers.SubscriptionTierMapper;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.Feature;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.SubscriptionTier;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.FeatureRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories.SubscriptionTierRepository;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Services.SubscriptionTierService;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.DatabaseOperationException;
import com.sbsolutions.ClientManagementPortal.Global.Exceptions.ResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionTierServiceImpl implements SubscriptionTierService {
    private  final FeatureRepository featureRepository;

    private final SubscriptionTierRepository subscriptionTierRepository;

    public SubscriptionTierServiceImpl(FeatureRepository featureRepository, SubscriptionTierRepository subscriptionTierRepository) {
        this.featureRepository = featureRepository;
        this.subscriptionTierRepository = subscriptionTierRepository;
    }

    @Override
    public SubscriptionTierDTO createSubscriptionTier(SubscriptionTierDTO subscriptionTierDTO) {

        // Convert DTO to Entity
        SubscriptionTier subscriptionTier = SubscriptionTierMapper.toEntity(subscriptionTierDTO);

        // Check if features are provided (Features should be already created)
        if (subscriptionTierDTO.getFeaturesList() != null && !subscriptionTierDTO.getFeaturesList().isEmpty()) {
            List<Long> featureIds = subscriptionTierDTO.getFeaturesList().stream()
                    .map(FeatureDTO::getFeatureId)
                    .collect(Collectors.toList());

            // Fetch features that were already saved
            List<Feature> existingFeatures = featureRepository.findAllById(featureIds);

            // Associate features with subscription tier
            existingFeatures.forEach(feature -> feature.setSubscriptionTier(subscriptionTier));

            subscriptionTier.setFeatures(existingFeatures);
        }

        // Save Subscription Tier
        SubscriptionTier savedTier = subscriptionTierRepository.save(subscriptionTier);
        return SubscriptionTierMapper.toDTO(savedTier);
    }

    @Override
    public SubscriptionTierDTO getSubscriptionTierById(Long tierId) {
        try {
            SubscriptionTier subscriptionTier = subscriptionTierRepository.findById(tierId)
                    .orElseThrow(() -> new ResourceNotFoundException("SubscriptionTier", "ID", tierId));
            return SubscriptionTierMapper.toDTO(subscriptionTier);
        } catch (DataAccessException e) {
            throw new DatabaseOperationException("Database error while fetching subscription tier: " + e.getMessage());
        }
    }

    @Override
    public List<SubscriptionTierDTO> getAllSubscriptionTiers() {
        try {
            return subscriptionTierRepository.findAll()
                    .stream()
                    .map(SubscriptionTierMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DatabaseOperationException("Database error while fetching subscription tiers: " + e.getMessage());
        }
    }

    @Override
    public SubscriptionTierDTO updateSubscriptionTier(Long tierId, SubscriptionTierDTO subscriptionTierDTO) {
        try {
            // Fetch existing SubscriptionTier
            SubscriptionTier existingTier = subscriptionTierRepository.findById(tierId)
                    .orElseThrow(() -> new ResourceNotFoundException("SubscriptionTier", "ID", tierId));

            // Update tier fields
            existingTier.setTierType(subscriptionTierDTO.getTierType());
            existingTier.setDescription(subscriptionTierDTO.getDescription());
            existingTier.setPrice(subscriptionTierDTO.getPrice());

            // Check if features are provided in the update request
            if (subscriptionTierDTO.getFeaturesList() != null && !subscriptionTierDTO.getFeaturesList().isEmpty()) {
                List<Long> featureIds = subscriptionTierDTO.getFeaturesList().stream()
                        .map(FeatureDTO::getFeatureId)
                        .collect(Collectors.toList());

                // Fetch existing features by ID
                List<Feature> existingFeatures = featureRepository.findAllById(featureIds);

                // Clear old feature associations (if any)
                existingTier.getFeatures().forEach(feature -> feature.setSubscriptionTier(null));

                // Associate new features with this SubscriptionTier
                existingFeatures.forEach(feature -> feature.setSubscriptionTier(existingTier));

                existingTier.setFeatures(existingFeatures);
            }

            // Save updated SubscriptionTier
            SubscriptionTier updatedTier = subscriptionTierRepository.save(existingTier);
            return SubscriptionTierMapper.toDTO(updatedTier);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while updating subscription tier: " + e.getMessage());
        }
    }

    @Override
    public DeletionResponse deleteSubscriptionTier(Long tierId) {
        try {
            SubscriptionTier subscriptionTier = subscriptionTierRepository.findById(tierId)
                    .orElseThrow(() -> new ResourceNotFoundException("SubscriptionTier", "ID", tierId));
            
            subscriptionTierRepository.delete(subscriptionTier);
            return new DeletionResponse(true, "Feature deleted successfully");
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while deleting subscription tier: " + e.getMessage());
        }
    }
}
