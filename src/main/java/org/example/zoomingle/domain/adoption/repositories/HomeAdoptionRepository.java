package org.example.zoomingle.domain.adoption.repositories;

import org.example.zoomingle.domain.adoption.HomeAdoption;

import java.util.List;

public interface HomeAdoptionRepository {
    public void registerHomeAdoption(
            HomeAdoption homeAdoption
    );

    public void modifyHomeAdoption(
            HomeAdoption homeAdoption
    );

    public void deleteHomeAdoption(
            HomeAdoption homeAdoption
    );

    public HomeAdoption findByIdHomeAdoption(
            Long id
    );

    public List<HomeAdoption> findAllHomeAdoption();


}
