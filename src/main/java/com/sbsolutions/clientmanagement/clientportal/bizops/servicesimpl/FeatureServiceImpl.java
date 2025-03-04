package com.sbsolutions.clientmanagement.clientportal.bizops.servicesimpl;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Feature;
import com.sbsolutions.clientmanagement.clientportal.bizops.mappers.FeatureMapper;
import com.sbsolutions.clientmanagement.clientportal.bizops.repositories.FeatureRepository;
import com.sbsolutions.clientmanagement.clientportal.bizops.services.FeatureService;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.DatabaseOperationException;
import com.sbsolutions.clientmanagement.clientportal.web.exceptions.ResourceNotFoundException;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.FeatureDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public FeatureDTO createFeature(FeatureDTO featureDTO) {
        try {
            Feature feature = FeatureMapper.toEntity(featureDTO);
            Feature savedFeature = featureRepository.save(feature);
            return FeatureMapper.toDTO(savedFeature);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while saving feature: " + e.getMessage());
        }
    }


    @Override
    public FeatureDTO getFeatureById(Long featureId) {
        try {
            Feature feature = featureRepository.findById(featureId)
                    .orElseThrow(() -> new ResourceNotFoundException("Feature", "ID", featureId));
            return FeatureMapper.toDTO(feature);
        } catch (DataAccessException e) {
            throw new DatabaseOperationException("Database error while fetching feature: " + e.getMessage());
        }
    }

    @Override
    public List<FeatureDTO> getAllFeatures() {
        try {
            return featureRepository.findAll()
                    .stream()
                    .map(FeatureMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DatabaseOperationException("Database error while fetching features: " + e.getMessage());
        }
    }

    @Override
    public FeatureDTO updateFeature(Long featureId, FeatureDTO featureDTO) {
        try {
            Feature existingFeature = featureRepository.findById(featureId)
                    .orElseThrow(() -> new ResourceNotFoundException("Feature", "ID", featureId));

            existingFeature.setName(featureDTO.getName());
            existingFeature.setDescription(featureDTO.getDescription());
            existingFeature.setPremium(featureDTO.isPremium());

            Feature updatedFeature = featureRepository.save(existingFeature);
            return FeatureMapper.toDTO(updatedFeature);
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while updating feature: " + e.getMessage());
        }
    }

    @Override
    public DeletionResponse deleteFeature(Long featureId) {
        try {
            Feature feature = featureRepository.findById(featureId)
                    .orElseThrow(() -> new ResourceNotFoundException("Feature", "ID", featureId));

            featureRepository.delete(feature);
            return new DeletionResponse(true, "Feature deleted successfully");
        } catch (DataAccessException e) {
            throw new DatabaseOperationException("Error while deleting feature: " + e.getMessage());
        }

    }
}
