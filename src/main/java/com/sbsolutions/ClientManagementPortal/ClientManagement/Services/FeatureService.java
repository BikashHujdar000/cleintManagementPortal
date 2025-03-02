package com.sbsolutions.ClientManagementPortal.ClientManagement.Services;


import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.DeletionResponse;
import com.sbsolutions.ClientManagementPortal.ClientManagement.Dtos.FeatureDTO;

import java.util.List;

public interface FeatureService {
    FeatureDTO createFeature(FeatureDTO featureDTO);

    FeatureDTO updateFeature(Long id, FeatureDTO featureDTO);

    FeatureDTO getFeatureById(Long id);

    List<FeatureDTO> getAllFeatures();

    DeletionResponse deleteFeature(Long id);
}
