package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found with id: " + id));
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existingGarage = getGarageById(id);
        existingGarage.setName(garage.getName());
        existingGarage.setLocation(garage.getLocation());
        existingGarage.setContactNumber(garage.getContactNumber());
        return garageRepository.save(existingGarage);
    }

    @Override
    public void deleteGarage(Long id) {
        Garage garage = getGarageById(id);
        garageRepository.delete(garage);
    }
}
