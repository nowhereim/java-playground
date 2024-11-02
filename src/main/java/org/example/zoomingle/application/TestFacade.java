package org.example.zoomingle.application;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.TestModel;
import org.example.zoomingle.domain.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestFacade {

    private final TestService testService;

    public String test(String args) {
        return testService.test(args);
    }

    public List<TestModel> test2(String args) {
        return testService.test2(args);
    }

    public TestModel createTest(TestModel testModel) {
        return testService.createTest(testModel);
    }
}
