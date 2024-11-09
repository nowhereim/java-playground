package org.example.zoomingle.interfaces.test;

import jakarta.validation.constraints.*;
import lombok.*;
import org.example.zoomingle.domain.test.TestModel;

@Builder
@Getter // Getter 추가
public class TestDto {

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "이름은 필수입니다.")
    @Size(min = 3, max = 10, message = "이름은 3자 이상 10자 이하이어야 합니다.")
    private String name;



    public static TestModel toDto(TestDto payment) {
        return TestModel.builder()
                .email(payment.getEmail())
                .name(payment.getName())
                .build();
    }
}
