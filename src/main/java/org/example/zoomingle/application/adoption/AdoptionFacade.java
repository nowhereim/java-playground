package org.example.zoomingle.application.adoption;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;
import org.example.zoomingle.domain.adoption.services.HomeAdoptionService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
//
public class AdoptionFacade {
    private final HomeAdoptionService homeAdoptionService;

    public HomeAdoption registerHomeAdoption(
            HomeAdoption homeAdoption) {
        return homeAdoptionService.registerHomeAdoption(homeAdoption);
    }

    public HomeAdoption findByIdHomeAdoption(Long id) {
        return homeAdoptionService.findByIdHomeAdoption(id);
    }

    public void modifyHomeAdoption(HomeAdoption homeAdoption) {
        homeAdoptionService.modifyHomeAdoption(homeAdoption);
    }

    public void deleteHomeAdoption(HomeAdoption homeAdoption) {
        homeAdoptionService.deleteHomeAdoption(homeAdoption);
    }

    public List<HomeAdoption> findAllHomeAdoption() {
        return homeAdoptionService.findAllHomeAdoption();
    }
}