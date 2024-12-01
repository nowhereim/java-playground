package org.example.zoomingle.interfaces.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponseDto {
    private String token;

    public static ResponseDto toResponseDto(String token) {
        return ResponseDto.builder()
                .token(token)
                .build();
    }
}
