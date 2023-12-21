package com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.services;

import com.codedifferently.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.models.MaintenanceRequest;
import com.codedifferently.maintenancerequestserver.domain.maintanenceRequest.repos.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
    private MaintenanceRequestRepository maintenanceRequestRepository;
@Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepository maintenanceRequestRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }
    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepository.findByEmail(maintenanceRequest.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Maintenance with email exists: "+ maintenanceRequest.getEmail());
        maintenanceRequest = maintenanceRequestRepository.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No maintenance request with id: " + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
    MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findByEmail(email)
            .orElseThrow(()-> new ResourceNotFoundException("No maintenance request with email: " + email));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepository.findByAptNumber(aptNumber)
                .orElseThrow(()-> new ResourceNotFoundException("No maintenance request with apartment number: " + aptNumber));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepository.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest maintenanceRequestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(maintenanceRequestDetail.getFirstName());
        maintenanceRequest.setLastName(maintenanceRequestDetail.getLastName());
        maintenanceRequest.setEmail(maintenanceRequestDetail.getEmail());
        maintenanceRequest.setAptNumber(maintenanceRequestDetail.getAptNumber());
        maintenanceRequest.setDescription(maintenanceRequestDetail.getDescription());
        maintenanceRequest.setCreatedAt(maintenanceRequestDetail.getCreatedAt());
        maintenanceRequest = maintenanceRequestRepository.save(maintenanceRequest);
        return maintenanceRequest;
    }


    @Override
    public void delete(Long id) {
            MaintenanceRequest maintenanceRequest = getById(id);
            maintenanceRequestRepository.delete(maintenanceRequest);

        }
}
