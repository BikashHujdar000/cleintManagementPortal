package com.sbsolutions.ClientManagementPortal.ClientManagement.Repositories;

import com.sbsolutions.ClientManagementPortal.ClientManagement.Models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
