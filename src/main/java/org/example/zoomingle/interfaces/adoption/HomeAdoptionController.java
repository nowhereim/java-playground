package org.example.zoomingle.interfaces.adoption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.example.zoomingle.interfaces.adoption.dto.HomeAdpotionRegisterRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/adoption/home")
public class HomeAdoptionController {


    @Operation(summary = "가정분양 등록" , description = "가정분양을 등록하는 API")
    @PostMapping("/register")
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public @Valid HomeAdpotionRegisterRequestDTO registerAdoption(
            @RequestBody @Valid HomeAdpotionRegisterRequestDTO requestDto
            ){

        return requestDto;

    }

    @Operation(summary = "가정분양 상세 조회" , description = "가정분양을 상세 조회하는 API")
    public void getAdoptionDetail(){

    }

    @Operation(summary = "가정분양 목록 조회" , description = "가정분양 목록을 조회하는 API")
    public void getAdoptionList(){

    }

    @Operation(summary = "가정분양 수정" , description = "가정분양을 수정하는 API")
    public void updateAdoption(){

    }

    @Operation(summary = "가정분양 삭제" , description = "가정분양을 삭제하는 API")
    public void deleteAdoption(){

    }

}
