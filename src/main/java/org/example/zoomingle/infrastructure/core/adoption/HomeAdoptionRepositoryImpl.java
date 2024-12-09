package org.example.zoomingle.infrastructure.core.adoption;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;
import org.example.zoomingle.domain.adoption.repositories.HomeAdoptionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class HomeAdoptionRepositoryImpl implements HomeAdoptionRepository {
    private final HomeAdoptionJpaRepository homeAdoptionJpaRepository;
    @Override
    public HomeAdoption registerHomeAdoption(HomeAdoption homeAdoption) {
        HomeAdoptionEntity entity = HomeAdoptionEntity.builder()
                .id(homeAdoption.getId())
                .birth(homeAdoption.getBirth())
                .adoptionCondition(homeAdoption.getAdoptionCondition())
                .additionalInfo(homeAdoption.getAdditionalInfo())
                .breedId(homeAdoption.getBreedId())
                .gender(homeAdoption.getGender())
                .neuteringStatus(homeAdoption.getNeuteringStatus())
                .userId(homeAdoption.getUserId())
                .vaccinationStatus(homeAdoption.getVaccinationStatus())
                .weight(homeAdoption.getWeight())
                .address(homeAdoption.getAddress())
                .responsibilityFee(homeAdoption.getResponsibilityFee())
                .responsibilityFeeStoragePeriod(homeAdoption.getResponsibilityFeeStoragePeriod())
                .build();

        HomeAdoptionEntity homeAdoptionEntity = homeAdoptionJpaRepository.save(entity);
        return HomeAdoption.builder()
                .id(homeAdoptionEntity.getId())
                .birth(homeAdoptionEntity.getBirth())
                .adoptionCondition(homeAdoptionEntity.getAdoptionCondition())
                .additionalInfo(homeAdoptionEntity.getAdditionalInfo())
                .breedId(homeAdoptionEntity.getBreedId())
                .gender(homeAdoptionEntity.getGender())
                .neuteringStatus(homeAdoptionEntity.getNeuteringStatus())
                .userId(homeAdoptionEntity.getUserId())
                .vaccinationStatus(homeAdoptionEntity.getVaccinationStatus())
                .weight(homeAdoptionEntity.getWeight())
                .address(homeAdoptionEntity.getAddress())
                .responsibilityFee(homeAdoptionEntity.getResponsibilityFee())
                .responsibilityFeeStoragePeriod(homeAdoptionEntity.getResponsibilityFeeStoragePeriod())
                .build();

    }

    @Override
    public void modifyHomeAdoption(HomeAdoption homeAdoption) {
        HomeAdoptionEntity entity = HomeAdoptionEntity.builder()
                .id(homeAdoption.getId())
                .birth(homeAdoption.getBirth())
                .adoptionCondition(homeAdoption.getAdoptionCondition())
                .additionalInfo(homeAdoption.getAdditionalInfo())
                .breedId(homeAdoption.getBreedId())
                .gender(homeAdoption.getGender())
                .neuteringStatus(homeAdoption.getNeuteringStatus())
                .userId(homeAdoption.getUserId())
                .vaccinationStatus(homeAdoption.getVaccinationStatus())
                .weight(homeAdoption.getWeight())
                .address(homeAdoption.getAddress())
                .responsibilityFee(homeAdoption.getResponsibilityFee())
                .responsibilityFeeStoragePeriod(homeAdoption.getResponsibilityFeeStoragePeriod())
                .build();

        homeAdoptionJpaRepository.save(entity);

    }

    @Override
    public void deleteHomeAdoption(HomeAdoption homeAdoption) {

    }

    @Override
    public HomeAdoption findByIdHomeAdoption(Long id) {
        return homeAdoptionJpaRepository.findById(id)
                .map(entity -> HomeAdoption.builder()
                        .id(entity.getId())
                        .birth(entity.getBirth())
                        .adoptionCondition(entity.getAdoptionCondition())
                        .additionalInfo(entity.getAdditionalInfo())
                        .breedId(entity.getBreedId())
                        .gender(entity.getGender())
                        .neuteringStatus(entity.getNeuteringStatus())
                        .userId(entity.getUserId())
                        .vaccinationStatus(entity.getVaccinationStatus())
                        .weight(entity.getWeight())
                        .address(entity.getAddress())
                        .responsibilityFee(entity.getResponsibilityFee())
                        .responsibilityFeeStoragePeriod(entity.getResponsibilityFeeStoragePeriod())
                        .build()
                ).orElse(null);
    }

    @Override
    public List<HomeAdoption> findAllHomeAdoption() {
        return homeAdoptionJpaRepository.findAll()
                .stream()
                .map(entity -> HomeAdoption.builder()
                        .id(entity.getId())
                        .birth(entity.getBirth())
                        .adoptionCondition(entity.getAdoptionCondition())
                        .additionalInfo(entity.getAdditionalInfo())
                        .breedId(entity.getBreedId())
                        .gender(entity.getGender())
                        .neuteringStatus(entity.getNeuteringStatus())
                        .userId(entity.getUserId())
                        .vaccinationStatus(entity.getVaccinationStatus())
                        .weight(entity.getWeight())
                        .address(entity.getAddress())
                        .responsibilityFee(entity.getResponsibilityFee())
                        .responsibilityFeeStoragePeriod(entity.getResponsibilityFeeStoragePeriod())
                        .build()
                ).toList();

    }
}
