package org.example.zoomingle.interfaces.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageDTO {
    @NotBlank(message = "유효한 파일 형식 이어야 합니다.")
//    @Pattern(
//            message = "유효한 파일 형식 이어야 합니다."
//    )
    private String image;

    @NotNull(message = "isMain 값은 필수입니다.")
    private Boolean isMain; // 메인 이미지 여부
}