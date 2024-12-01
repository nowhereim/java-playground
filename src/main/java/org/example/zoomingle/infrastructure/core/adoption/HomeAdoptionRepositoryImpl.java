package org.example.zoomingle.infrastructure.core.adoption;

import org.example.zoomingle.domain.adoption.HomeAdoption;
import org.example.zoomingle.domain.adoption.repositories.HomeAdoptionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeAdoptionRepositoryImpl implements HomeAdoptionRepository {
    @Override
    public void registerHomeAdoption(HomeAdoption homeAdoption) {

    }

    @Override
    public void modifyHomeAdoption(HomeAdoption homeAdoption) {

    }

    @Override
    public void deleteHomeAdoption(HomeAdoption homeAdoption) {

    }

    @Override
    public HomeAdoption findByIdHomeAdoption(Long id) {
        return null;
    }

    @Override
    public List<HomeAdoption> findAllHomeAdoption() {
        return List.of();
    }
}
