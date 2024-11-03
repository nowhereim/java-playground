package org.example.zoomingle.infrastructure.core.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
