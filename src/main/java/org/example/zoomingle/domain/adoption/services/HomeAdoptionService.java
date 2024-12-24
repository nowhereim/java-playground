package org.example.zoomingle.domain.adoption.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;
import org.example.zoomingle.domain.adoption.repositories.HomeAdoptionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeAdoptionService {
    private final HomeAdoptionRepository homeAdoptionRepository;

    public HomeAdoption registerHomeAdoption(HomeAdoption homeAdoption) {


        return homeAdoptionRepository.registerHomeAdoption(homeAdoption);

    }

    public void modifyHomeAdoption(HomeAdoption args) {
        HomeAdoption homeAdoption = homeAdoptionRepository.findByIdHomeAdoption(args.getId());
        if (homeAdoption == null) {
            throw new IllegalArgumentException("해당 입양 정보가 없습니다.");
        }
        homeAdoptionRepository.modifyHomeAdoption(args);
    }

    public void deleteHomeAdoption(Long id) {
        HomeAdoption homeAdoption = homeAdoptionRepository.findByIdHomeAdoption(id);
        homeAdoptionRepository.deleteHomeAdoption(homeAdoption);
    }

    public HomeAdoption findByIdHomeAdoption(Long id) {


        return homeAdoptionRepository.findByIdHomeAdoption(id);
    }

    public List<HomeAdoption> findAllHomeAdoption() {

        return homeAdoptionRepository.findAllHomeAdoption();
    }


}
