package com.example.ch4_user_currency.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.exception
 * <li>fileName       : ErrorCode
 * <li>date           : 24. 11. 28.
 * <li>description    : 커스텀 에러 코드
 * </ul>
 */

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 400
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "이메일 형식이 맞지 않습니다."),
    REQUIRED_INPUT_EMPTY(HttpStatus.BAD_REQUEST, "입력값이 누락되었습니다."),

    // 404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    CURRENCY_NOT_FOUND(HttpStatus.NOT_FOUND, "통화를 찾을 수 없습니다."),
    EXCHANGE_NOT_FOUND(HttpStatus.NOT_FOUND, "환전 요청을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
