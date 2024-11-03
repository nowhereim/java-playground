package org.example.zoomingle.interfaces.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.example.zoomingle.domain.user.User;

import java.util.Optional;

@Getter
public class UserRegisterRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String description;

    @NotBlank
    private String profile;


    public static User toDomain(UserRegisterRequestDto userRegisterRequestDto){
        return User
                .builder()
                .username(userRegisterRequestDto.getUsername())
                .password(userRegisterRequestDto.getPassword())
                .description(userRegisterRequestDto.getDescription())
                .profile(userRegisterRequestDto.getProfile())
                .build();
    }
}
