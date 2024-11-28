package com.example.ch4_user_currency.exception;

import lombok.Getter;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.exception
 * <li>fileName       : CustomException
 * <li>date           : 24. 11. 28.
 * <li>description    : 커스텀 예외
 * </ul>
 */

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
