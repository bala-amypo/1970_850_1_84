package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        return serviceEntryRepository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getServiceEntriesByVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
