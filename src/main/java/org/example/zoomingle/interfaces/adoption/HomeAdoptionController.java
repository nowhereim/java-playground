package org.example.zoomingle.interfaces.adoption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.adoption.AdoptionFacade;
import org.example.zoomingle.interfaces.adoption.dto.HomeAdoptionModifyRequestDTO;
import org.example.zoomingle.interfaces.adoption.dto.HomeAdoptionResponseDTO;
import org.example.zoomingle.interfaces.adoption.dto.HomeAdpotionRegisterRequestDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/adoption/home")
@Tag(name = "가정분양 API", description = "가정분양 API 입니다.")
@RequiredArgsConstructor
public class HomeAdoptionController {

    private final AdoptionFacade adoptionFacade;


    @Operation(summary = "가정분양 등록" , description = "가정분양을 등록하는 API")
    @PostMapping("/register")
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public HomeAdoptionResponseDTO registerAdoption(
            @RequestBody @Valid HomeAdpotionRegisterRequestDTO requestDto
            ){

        /**
         * FIXME: 여기좀 잘 봅시다
         * TODO: 여기서부터 하면 될 듯
         * */
        return HomeAdoptionResponseDTO.toResponse(adoptionFacade.registerHomeAdoption(
                HomeAdpotionRegisterRequestDTO.toDomain(
                        requestDto
                )
        ));

    }

    @Operation(summary = "가정분양 상세 조회" , description = "가정분양을 상세 조회하는 API")
    @GetMapping("/detail")
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public HomeAdoptionResponseDTO getAdoptionDetail(
            @Parameter(description = "가정분양 ID", required = true) Long id
    ){
        return HomeAdoptionResponseDTO.toResponse(adoptionFacade.findByIdHomeAdoption(id));

    }

    @Operation(summary = "가정분양 목록 조회" , description = "가정분양 목록을 조회하는 API")
    @GetMapping("/list")
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public List<HomeAdoptionResponseDTO> getAdoptionList(){

        return HomeAdoptionResponseDTO.toListResponse(adoptionFacade.findAllHomeAdoption());

    }

    @Operation(summary = "가정분양 수정" , description = "가정분양을 수정하는 API")
    @PatchMapping("/update")
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public void updateAdoption(
            @RequestBody @Valid HomeAdoptionModifyRequestDTO requestDTO
    ){
        adoptionFacade.modifyHomeAdoption(
                HomeAdoptionModifyRequestDTO.toDomain(
                        requestDTO
                )
        );

    }

    @Operation(summary = "가정분양 삭제" , description = "가정분양을 삭제하는 API")
    public void deleteAdoption(){

    }



}
