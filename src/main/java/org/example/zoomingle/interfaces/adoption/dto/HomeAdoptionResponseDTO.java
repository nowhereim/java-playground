package org.example.zoomingle.interfaces.adoption.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.adoption.model.HomeAdoption;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class HomeAdoptionResponseDTO {

    private Long id;
    private Long userId;
    private Long breedId;
    private LocalDate birth;

    public static HomeAdoptionResponseDTO toResponse(HomeAdoption homeAdoption) {


        return HomeAdoptionResponseDTO.builder()
                .id(homeAdoption.getId())
                .userId(homeAdoption.getUserId())
                .breedId(homeAdoption.getBreedId())
                .birth(homeAdoption.getBirth())
                .build();
    }

    public static List<HomeAdoptionResponseDTO> toListResponse(List<HomeAdoption> homeAdoptions) {
        return homeAdoptions.stream()
                .map(HomeAdoptionResponseDTO::toResponse)
                .toList();
    }
}
