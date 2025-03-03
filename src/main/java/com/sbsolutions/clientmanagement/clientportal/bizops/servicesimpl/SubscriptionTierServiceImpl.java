package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Feature;
import com.sbsolutions.clientmanagement.clientportal.bizops.entities.SubscriptionTier;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.SubscriptionTierMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.FeatureRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.SubscriptionTierRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.SubscriptionTierService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.ResourceNotFoundException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.FeatureDTO;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.SubscriptionTierDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionTierServiceImpl implements SubscriptionTierService {
    private final FeatureRepository featureRepository;

    private final SubscriptionTierRepository subscriptionTierRepository;

    public SubscriptionTierServiceImpl(FeatureRepository featureRepository, SubscriptionTierRepository subscriptionTierRepository) {
        this.featureRepository = featureRepository;
        this.subscriptionTierRepository = subscriptionTierRepository;
    }

    @Override
    public SubscriptionTierDTO createSubscriptionTier(SubscriptionTierDTO subscriptionTierDTO) {

        SubscriptionTier subscriptionTier = SubscriptionTierMapper.toEntity(subscriptionTierDTO);
        if (subscriptionTierDTO.getFeaturesList() != null && !subscriptionTierDTO.getFeaturesList().isEmpty()) {
            List<Long> featureIds = subscriptionTierDTO.getFeaturesList().stream()
                    .map(FeatureDTO::getFeatureId)
                    .collect(Collectors.toList());
            List<Feature> existingFeatures = featureRepository.findAllById(featureIds);
            existingFeatures.forEach(feature -> feature.setSubscriptionTier(subscriptionTier));

            subscriptionTier.setFeatures(existingFeatures);
        }
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
            SubscriptionTier existingTier = subscriptionTierRepository.findById(tierId)
                    .orElseThrow(() -> new ResourceNotFoundException("SubscriptionTier", "ID", tierId));
            existingTier.setTierType(subscriptionTierDTO.getTierType());
            existingTier.setDescription(subscriptionTierDTO.getDescription());
            existingTier.setPrice(subscriptionTierDTO.getPrice());
            if (subscriptionTierDTO.getFeaturesList() != null && !subscriptionTierDTO.getFeaturesList().isEmpty()) {
                List<Long> featureIds = subscriptionTierDTO.getFeaturesList().stream()
                        .map(FeatureDTO::getFeatureId)
                        .collect(Collectors.toList());
                List<Feature> existingFeatures = featureRepository.findAllById(featureIds);
                existingTier.getFeatures().forEach(feature -> feature.setSubscriptionTier(null));
                existingFeatures.forEach(feature -> feature.setSubscriptionTier(existingTier));
                existingTier.setFeatures(existingFeatures);
            }
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
