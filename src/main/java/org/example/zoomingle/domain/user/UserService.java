package org.example.zoomingle.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(User args) {

        return userRepository.save(
                User.builder()
                        .id(args.getId())
                        .username(args.getUsername())
                        .password(passwordEncoder.encode(args.getPassword()))
                        .description(args.getDescription())
                        .profile(args.getProfile())
                        .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER")))
                        .build()
        );
    }
}
