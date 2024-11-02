package org.example.zoomingle.interfaces;


import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.TestFacade;
import org.example.zoomingle.domain.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestFacade testFacade;

    @GetMapping("concerts")
    public String getTests(
            @RequestParam("sexy") String dto
    ){
        return testFacade.test(dto);
    }

    @GetMapping("concerts2")
    public List<TestModel> getTests2(
            @RequestParam("sexy") String dto
    ){
        return testFacade.test2(dto);
    }
}
