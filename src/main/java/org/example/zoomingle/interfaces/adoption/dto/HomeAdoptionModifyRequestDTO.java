package org.example.zoomingle.interfaces.adoption.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.zoomingle.domain.adoption.model.*;

import java.time.LocalDate;
import java.util.Optional;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeAdoptionModifyRequestDTO {

    @NotNull(message = "ID는 반드시 입력해야 합니다.")
    private long id;


    private long userId;


    private long breedId;

    @Past(message = "생일은 과거 날짜여야 합니다.")
    private LocalDate birth;

    private Weight weight;

    private VaccinationStatus vaccinationStatus;

    private Gender gender;

    private NeuteringStatus neuteringStatus;

    @Size(max = 255, message = "주소는 최대 255자까지 입력 가능합니다.")
    private String address;

    private String adoptionCondition;

    @Size(max = 500, message = "추가 정보는 최대 500자까지 입력 가능합니다.")
    private String additionalInfo;

    private int responsibilityFee;

    private int responsibilityFeeStoragePeriod;

    public static HomeAdoption toDomain(HomeAdoptionModifyRequestDTO dto) {

        return HomeAdoption.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .breedId(dto.getBreedId())
                .birth(dto.getBirth())
                .weight(dto.getWeight())
                .vaccinationStatus(dto.getVaccinationStatus())
                .gender(dto.getGender())
                .neuteringStatus(dto.getNeuteringStatus())
                .address(dto.getAddress())
                .adoptionCondition(dto.getAdoptionCondition())
                .additionalInfo(dto.getAdditionalInfo())
                .responsibilityFee(dto.getResponsibilityFee())
                .responsibilityFeeStoragePeriod(dto.getResponsibilityFeeStoragePeriod())
                .build();
    }
}
