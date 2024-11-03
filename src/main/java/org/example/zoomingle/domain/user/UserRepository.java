package org.example.zoomingle.domain.user;

public interface UserRepository {
    User findById(Long id);
    User save(User user);
    void delete(User user);
}
