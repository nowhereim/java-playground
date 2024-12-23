package org.example.zoomingle.interfaces.adoption.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import org.example.zoomingle.domain.adoption.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
//카멜케이스 -> 스네이크 케이스 어노테이션
public class HomeAdpotionRegisterRequestDTO {

    @NotNull(message = "유저 ID는 필수 항목입니다.")
    @Min(value = 1, message = "유저 ID는 1 이상이어야 합니다.")
    private long userId;

    @NotNull(message = "품종 ID는 필수 항목입니다.")
    @Min(value = 1, message = "품종 ID는 1 이상이어야 합니다.")
    private long breedId;

    @NotNull(message = "생일은 필수 항목입니다.")
    @Past(message = "생일은 과거 날짜여야 합니다.")
    private LocalDate birth;

    @NotNull(message = "몸무게는 필수 항목입니다.")
    private Weight weight;

    @NotNull(message = "예방 접종 상태는 필수 항목입니다.")
    private VaccinationStatus vaccinationStatus;

    @NotNull(message = "성별은 필수 항목입니다.")
    private Gender gender;

    @NotNull(message = "중성화 상태는 필수 항목입니다.")
    private NeuteringStatus neuteringStatus;

    @NotBlank(message = "주소는 필수 항목입니다.")
    @Size(max = 255, message = "주소는 최대 255자까지 입력 가능합니다.")
    private String address;

    @NotBlank(message = "입양 조건은 필수 항목입니다.")
    private String adoptionCondition;

    @Size(max = 500, message = "추가 정보는 최대 500자까지 입력 가능합니다.")
    private String additionalInfo;

    @PositiveOrZero(message = "책임비는 0을 포함한 양수여야 합니다.")
    private int responsibilityFee;

    @PositiveOrZero(message = "책임비 보관 기간은 0 이상이어야 합니다.")
    private int responsibilityFeeStoragePeriod;

    @Size(min = 1,max = 5, message = "분양 동물 이미지는 최소 1개 이상이어야 합니다.")
    @Schema(description = "분양 동물 이미지 목록", example = "[{\"image\":\"http://example.com\",\"isMain\":true},{\"image\":\"http://example.com\",\"isMain\":false}]")
    @Valid
    private List<ImageDTO> adoptionAnimalImages;

    @Size(min = 1, max = 5, message = "가정 환경 이미지는 최대 5개까지 가능합니다.")
    @Schema(description = "가정 환경 이미지 목록", example = "[{\"image\":\"http://example.com\",\"isMain\":true},{\"image\":\"http://example.com\",\"isMain\":false}]")
    @Valid
    private List<ImageDTO> homeEnvironmentImages;

    public static HomeAdoption toDomain(HomeAdpotionRegisterRequestDTO dto) {
        return HomeAdoption.builder()
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
                .adoptionAnimalImages(
                        dto.getAdoptionAnimalImages()
                                .stream()
                                .map(imageDTO ->
                                        Image.builder()
                                                .url(imageDTO.getImage())
                                                .isMain(imageDTO.getIsMain())
                                                .build()) // Image 객체로 변환
                                .collect(Collectors.toList()) // List<Image>로 수집
                )
                .homeEnvironmentImages(
                        dto.getHomeEnvironmentImages()
                                .stream()
                                .map(imageDTO ->
                                        Image.builder()
                                                .url(imageDTO.getImage())
                                                .isMain(imageDTO.getIsMain())
                                                .build()) // Image 객체로 변환
                                .collect(Collectors.toList()) // List<Image>로 수집
                )
                .build();

}
}