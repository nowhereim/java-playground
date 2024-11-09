package org.example.zoomingle.domain.test;

import java.util.List;

public interface TestRepository {
    String test(String args);

    List<TestModel> test2(String args);

    TestModel createTest(TestModel testModel);
}
