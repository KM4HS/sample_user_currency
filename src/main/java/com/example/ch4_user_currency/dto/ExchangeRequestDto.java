package com.example.ch4_user_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.dto
 * <li>fileName       : ExchangeRequestDto
 * <li>date           : 24. 11. 28.
 * <li>description    : 환전 요청 dto
 * </ul>
 */

@Getter
public class ExchangeRequestDto {

    private Long userId;
    private Long currencyId;
    private BigDecimal amountInKrw;

}
