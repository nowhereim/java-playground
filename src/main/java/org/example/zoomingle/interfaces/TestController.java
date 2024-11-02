package org.example.zoomingle.interfaces;


import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.TestFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}
