package com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.repos;

import com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);

    Optional<MaintenanceRequest> findByAptNumber(String aptNumber);
}
