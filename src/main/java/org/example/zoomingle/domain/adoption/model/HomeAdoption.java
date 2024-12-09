package org.example.zoomingle.domain.adoption.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class HomeAdoption {
    private long id;
    private long userId;
    private long breedId;
    private LocalDate birth;
    //몸무게는 이넘을 쓴다.
    private Weight weight;
    private VaccinationStatus vaccinationStatus;
    private Gender gender;
    private NeuteringStatus neuteringStatus;
    private String address;
    //입양 조건
    private String adoptionCondition;
    //추가 정보
    private String additionalInfo;//입양자가 추가로 알아야 할 정보
    //책임비
    private int responsibilityFee;
    // 책임비 보관 기간
    private int responsibilityFeeStoragePeriod;
    //분양 동물 이미지 URL
    private List<Image> adoptionAnimalImageURL;

    //가정 환경 이미지 URL
    private List<Image> homeEnvironmentImageURL;
}

