package org.example.zoomingle.domain.user.repositories;

import org.example.zoomingle.domain.user.User;

public interface UserRepository {
    User findById(Long id);
    User save(User user);
    void delete(User user);
}
