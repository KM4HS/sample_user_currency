package com.example.ch4_user_currency.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.exception
 * <li>fileName       : ExceptionDto
 * <li>date           : 24. 11. 28.
 * <li>description    : 예외 메세지를 반환하는 Dto
 * </ul>
 */

@Getter
@RequiredArgsConstructor
public class ExceptionResponseDto {
    private final String errorCode;
    private final String message;
}
