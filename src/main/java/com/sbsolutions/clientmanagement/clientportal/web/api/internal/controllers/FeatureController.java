package com.sbsolutions.clientmanagement.clientportal.web.api.internal.controllers;


import com.sbsolutions.clientmanagement.clientportal.bizops.services.FeatureService;
import com.sbsolutions.clientmanagement.global.globalresponse.RestResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.DeletionResponse;
import com.sbsolutions.clientmanagement.clientportal.web.dtos.FeatureDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/features")  // ✅ Changed to plural
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping
    public ResponseEntity<?> createFeature(@RequestBody FeatureDTO featureDTO) {
        FeatureDTO createdFeature = featureService.createFeature(featureDTO);
       return  new RestResponse<>().createdStatusWithPayload(createdFeature,"Feature created Successfully");
    }

    @GetMapping("/{featureId}")
    public ResponseEntity<?> getFeatureById(@PathVariable Long featureId) {
        FeatureDTO featureDTO = featureService.getFeatureById(featureId);
      return  new RestResponse<>().oKWithPayload(featureDTO,"Feature extracted Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllFeatures() {
        List<FeatureDTO> features = featureService.getAllFeatures();
        return new RestResponse<>().oKWithPayload(features, "All features retrieved successfully");
    }

    @PutMapping("/{featureId}")
    public ResponseEntity<?> updateFeature(@PathVariable Long featureId, @RequestBody FeatureDTO featureDTO) {
        FeatureDTO updatedFeature = featureService.updateFeature(featureId, featureDTO);
        return new RestResponse<>().createdStatusWithPayload(updatedFeature, "Feature updated successfully");
    }

    @DeleteMapping("/{featureId}")
    public ResponseEntity<?> deleteFeature(@PathVariable Long featureId) {
        DeletionResponse response = featureService.deleteFeature(featureId);
        return new RestResponse<>().oKWithPayload(response, "Feature deleted successfully");
    }
}
