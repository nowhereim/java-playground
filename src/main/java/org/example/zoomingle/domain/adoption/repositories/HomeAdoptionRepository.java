package org.example.zoomingle.domain.adoption.repositories;

import org.example.zoomingle.domain.adoption.model.HomeAdoption;

import java.util.List;

public interface HomeAdoptionRepository {
     HomeAdoption registerHomeAdoption(
            HomeAdoption homeAdoption
    );

    void modifyHomeAdoption(
            HomeAdoption homeAdoption
    );

     void deleteHomeAdoption(
            HomeAdoption homeAdoption
    );

     HomeAdoption findByIdHomeAdoption(
            Long id
    );

     List<HomeAdoption> findAllHomeAdoption();


}
