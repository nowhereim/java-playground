package org.example.zoomingle.interfaces.adoption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.adoption.AdoptionFacade;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Tag(name = "이미지 API", description = "이미지 API 입니다.")
@RequiredArgsConstructor
public class ImageController {
    private final AdoptionFacade adoptionFacade;

    @Operation(summary = "이미지 임시 등록" , description = "이미지를 임시로 등록하는 API")
    @PostMapping(value = "/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @SecurityRequirement(name = "Bearer")  // Bearer 토큰을 요구함
    public String registerImage(
            @RequestPart("file") MultipartFile file
    )throws IOException {

        return adoptionFacade.uploadImage(file);

    }
}
