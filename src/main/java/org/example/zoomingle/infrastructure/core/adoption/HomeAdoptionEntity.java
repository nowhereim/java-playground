package org.example.zoomingle.infrastructure.core.adoption;

import jakarta.persistence.*;
import lombok.*;
import org.example.zoomingle.domain.adoption.model.Gender;
import org.example.zoomingle.domain.adoption.model.NeuteringStatus;
import org.example.zoomingle.domain.adoption.model.VaccinationStatus;
import org.example.zoomingle.domain.adoption.model.Weight;
import org.example.zoomingle.infrastructure.core.base.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@Table(name = "home_adoptions")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@SQLRestriction("delete_datetime is null")
public class HomeAdoptionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}