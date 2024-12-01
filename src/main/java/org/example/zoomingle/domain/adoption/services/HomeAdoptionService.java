package org.example.zoomingle.domain.adoption.services;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.adoption.HomeAdoption;
import org.example.zoomingle.domain.adoption.repositories.HomeAdoptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeAdoptionService {
    private final HomeAdoptionRepository homeAdoptionRepository;
    public void registerAdoption(HomeAdoption homeAdoption) {
        homeAdoptionRepository.registerHomeAdoption(homeAdoption);

    }

    public void modifyAdoption(HomeAdoption homeAdoption) {
        homeAdoptionRepository.modifyHomeAdoption(homeAdoption);

    }

    public void deleteAdoption(HomeAdoption homeAdoption) {
        homeAdoptionRepository.deleteHomeAdoption(homeAdoption);
    }

    public HomeAdoption findByIdAdoption(Long id) {
        homeAdoptionRepository.findByIdHomeAdoption(id);

        return null;
    }

    public List<HomeAdoption> findAllAdoption() {
        homeAdoptionRepository.findAllHomeAdoption();

        return null;
    }
}
