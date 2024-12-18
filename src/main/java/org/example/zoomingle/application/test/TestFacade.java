package org.example.zoomingle.application.test;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.test.JwtTestService;
import org.example.zoomingle.domain.test.TestModel;
import org.example.zoomingle.domain.test.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TestFacade {

    private final TestService testService;
    private final JwtTestService jwtTestService;

    public String test(String args) {
        return testService.test(args);
    }

    public List<TestModel> test2(String args) {
        return testService.test2(args);
    }

    public TestModel createTest(TestModel testModel) {
        return testService.createTest(testModel);
    }

    public String createToken(String email) {
        return jwtTestService.generateAccessToken();
    }
}
