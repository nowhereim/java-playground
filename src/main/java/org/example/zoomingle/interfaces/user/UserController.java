package org.example.zoomingle.interfaces.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.user.UserFacade;
import org.example.zoomingle.domain.user.User;
import org.example.zoomingle.interfaces.user.dto.UserRegisterRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("/public/register")
    public User register(
            @RequestBody @Valid UserRegisterRequestDto userRegisterRequestDto
            ){
        return userFacade.register(userRegisterRequestDto.toDomain(
                userRegisterRequestDto
        ));
    }

}
