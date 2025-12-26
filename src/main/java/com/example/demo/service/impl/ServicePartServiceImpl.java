package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.repository.ServiceEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createServicePart(ServicePart servicePart) {
        return servicePartRepository.save(servicePart);
    }

    @Override
    public List<ServicePart> getPartsByServiceEntry(Long serviceEntryId) {
        return servicePartRepository.findByServiceEntryId(serviceEntryId);
    }
    
    public ServicePart createPart(ServicePart servicePart) {
        ServiceEntry entry = serviceEntryRepository.findById(servicePart.getServiceEntry().getId())
                .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));
        
        if (servicePart.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        return servicePartRepository.save(servicePart);
    }
}
