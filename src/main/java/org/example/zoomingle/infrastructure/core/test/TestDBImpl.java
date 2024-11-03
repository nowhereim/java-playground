package org.example.zoomingle.infrastructure.core.test;


import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.TestModel;
import org.example.zoomingle.domain.TestRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return " 어서오세요. 당신의 이메일은 = "
                + converted.getEmail()
                + " 너의 이름은 = "
                + converted.getName()
                + " 너의 아이디는 = " + converted.getId();
    }

    @Override
    public List<TestModel> test2(String args) {
        List<TestEntity> testEntity = testJpaRepository.findAll();
        return testEntity.stream().map(
                entity -> new TestModel(
                        entity.getId(),
                        entity.getName(),
                        entity.getEmail()
                )
        ).toList();

    }

    @Override
    public TestModel createTest(TestModel testModel) {
        TestEntity testEntity = new TestEntity(
                testModel.getId(),
                testModel.getName(),
                testModel.getEmail()
        );
        TestEntity saved = testJpaRepository.save(testEntity);
        return new TestModel(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }
}
