package com.sbsolutions.clientmanagement.clientportal.bizops.services;


import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.FeatureDTO;

import java.util.List;

public interface FeatureService {
    FeatureDTO createFeature(FeatureDTO featureDTO);

    FeatureDTO updateFeature(Long id, FeatureDTO featureDTO);

    FeatureDTO getFeatureById(Long id);

    List<FeatureDTO> getAllFeatures();

    DeletionResponse deleteFeature(Long id);
}
