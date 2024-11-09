package org.example.zoomingle.domain.test;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor // 이거 없이 하려면 직접 생성자를 만들어야 함
public class TestService {

    private final TestRepository testDB;

    public TestService(TestRepository testDB) { // 이렇게하면 Bean을 주입받을 수 있음
        this.testDB = testDB;
    }

    public String test(String args) {
        return testDB.test(args);
    }

    public List<TestModel> test2(String args) {
        return testDB.test2(args);
    }

    public TestModel createTest(TestModel testModel) {
        return testDB.createTest(testModel);
    }
}
