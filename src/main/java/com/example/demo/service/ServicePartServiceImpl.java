package com.example.demo.service;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository) {
        this.servicePartRepository = servicePartRepository;
    }

    @Override
    public ServicePart createServicePart(ServicePart servicePart) {
        return servicePartRepository.save(servicePart);
    }

    @Override
    public List<ServicePart> getPartsByServiceEntry(Long serviceEntryId) {
        return servicePartRepository.findByServiceEntryId(serviceEntryId);
    }
}
