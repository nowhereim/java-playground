package org.example.zoomingle.interfaces;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.zoomingle.application.TestFacade;
import org.example.zoomingle.domain.TestModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Tag(name = "테스트 컨트롤러", description = "테스트를 위한 API")
public class TestController {

    private final TestFacade testFacade;

    @GetMapping("concerts")
    @Operation(summary = "테스트 스트링 조회", description = "테스트 스트링을 조회하는 API")
    public String getTests(
            @RequestParam("sexy") String dto
    ){
        return testFacade.test(dto);
    }

    @GetMapping("concerts2")
    @Operation(summary = "테스트 리스트 조회", description = "테스트 리스트를 조회하는 API")
    public List<TestModel> getTests2(
            @RequestParam("sexy") String dto
    ){
        return testFacade.test2(dto);
    }

    @PostMapping("concerts")
    @Operation(summary = "테스트 데이터 생성", description = "테스트 데이터를 생성")
    public TestModel createTest(
            @RequestBody @Valid TestDto dto
    ){
        return testFacade.createTest(TestDto.toDto(dto));
    }
}
