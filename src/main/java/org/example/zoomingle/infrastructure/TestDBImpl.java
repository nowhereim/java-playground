package org.example.zoomingle.infrastructure;


import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.TestRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestDBImpl implements TestRepository {

    private final TestJpaRepository testJpaRepository;

    public String test(String args) {
        TestEntity testEntity = testJpaRepository.findById(1L).orElseThrow();
        TestEntity converted = new TestEntity(
                testEntity.getId(),
                testEntity.getName(),
                testEntity.getEmail()
        );
        System.out.println("converted = " + converted);
        return " 어서오세요. 당신의 이메일은 = "
                + converted.getEmail()
                + " 너의 이름은 = "
                + converted.getName()
                + " 너의 아이디는 = " + converted.getId();
    }
}
