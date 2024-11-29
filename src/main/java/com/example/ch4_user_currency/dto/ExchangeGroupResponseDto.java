package com.example.ch4_user_currency.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.dto
 * <li>fileName       : ExchangeGroupRequestDto
 * <li>date           : 24. 11. 29.
 * <li>description    : 그룹화된 환전 요청 응답
 * </ul>
 */

@Getter
@RequiredArgsConstructor
public class ExchangeGroupResponseDto {
    private final int count;
    private final BigDecimal totalAmountInKrw;
}
