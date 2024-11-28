package com.example.ch4_user_currency.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.exception
 * <li>fileName       : GlobalExceptionHandler
 * <li>date           : 24. 11. 28.
 * <li>description    : 전역으로 예외를 처리하는 클래스
 * </ul>
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 커스텀 예외 처리
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ExceptionResponseDto> handleCustomException(CustomException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponseDto(
                        e.getErrorCode().name(),
                        e.getMessage()
                )
        );
    }

    /**
     * Pattern을 이용한 예외 처리
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ExceptionResponseDto> handlePatternException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponseDto(
                        e.getErrorCode(),
                        e.getMessage()
                )
        );
    }

    /**
     * Valid 예외 처리
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponseDto> handlePatternException(MethodArgumentNotValidException e) {
        String collectedMsg = e.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.badRequest().body(
                new ExceptionResponseDto(
                        ErrorCode.REQUIRED_INPUT_EMPTY.name(),
                        collectedMsg
                )
        );
    }
}
