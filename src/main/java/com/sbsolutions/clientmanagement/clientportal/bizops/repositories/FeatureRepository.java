package com.sbsolutions.clientmanagement.clientportal.bizops.repositories;

import com.sbsolutions.clientmanagement.clientportal.bizops.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
