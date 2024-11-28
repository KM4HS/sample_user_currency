package com.example.ch4_user_currency.dto;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "유저 정보를 입력해주세요.")
    private Long userId;

    @NotNull(message = "환율 정보를 입력해주세요.")
    private Long currencyId;

    @NotNull(message = "환전할 금액(원)을 입력해주세요.")
    private BigDecimal amountInKrw;
}
