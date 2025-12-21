package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ServicePart createPart(@RequestBody ServicePart part) {
        return servicePartService.createServicePart(part);
    }

    @GetMapping("/service-entry/{serviceEntryId}")
    public List<ServicePart> getByServiceEntry(@PathVariable Long serviceEntryId) {
        return servicePartService.getPartsByServiceEntry(serviceEntryId);
    }
}
