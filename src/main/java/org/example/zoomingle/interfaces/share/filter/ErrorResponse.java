package org.example.zoomingle.interfaces.share.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<FieldError> errors; // 이 부분이 인식되지 않을 수 있음

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String errorMessage;
    }
}