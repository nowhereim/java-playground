package org.example.zoomingle.infrastructure.core.user;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.user.User;
import org.example.zoomingle.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {

        UserEntity save = userJpaRepository.save(
                UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .description(user.getDescription())
                .profile(user.getProfile())
                .build()
        );

        return User.builder()
                .id(save.getId())
                .username(save.getUsername())
                .password(save.getPassword())
                .description(save.getDescription())
                .profile(save.getProfile())
                .build();


    }

    @Override
    public void delete(User user) {

    }
}
