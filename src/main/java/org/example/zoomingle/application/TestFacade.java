package org.example.zoomingle.application;

import lombok.RequiredArgsConstructor;
import org.example.zoomingle.domain.TestService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestFacade {

    private final TestService testService;
    public String test(String args) {
        return testService.test(args);
    }
}
