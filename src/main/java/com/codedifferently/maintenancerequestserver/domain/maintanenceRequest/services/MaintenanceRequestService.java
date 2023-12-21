package com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.services;

import com.codedifferently.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException;
    void delete(Long id);

}
