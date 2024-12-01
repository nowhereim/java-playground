package org.example.zoomingle.interfaces.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageDTO {
    @NotBlank(message = "이미지 URL은 필수입니다.")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "유효한 URL 형식이어야 합니다."
    )
    private String url;

    @NotNull(message = "isMain 값은 필수입니다.")
    private Boolean isMain; // 메인 이미지 여부
}