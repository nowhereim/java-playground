package org.example.zoomingle.application.user;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.user.User;
import org.example.zoomingle.domain.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    public User register(User args) {
         return userService.register(args);
    }
}
