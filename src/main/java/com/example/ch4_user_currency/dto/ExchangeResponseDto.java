package com.example.ch4_user_currency.dto;

import com.example.ch4_user_currency.entity.ExchangeStatus;
import com.example.ch4_user_currency.entity.Exchange;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.dto
 * <li>fileName       : ExchangeResponseDto
 * <li>date           : 24. 11. 28.
 * <li>description    : 환전 응답 dto
 * </ul>
 */

@Getter
@RequiredArgsConstructor
public class ExchangeResponseDto {

    private final BigDecimal amountInKrw;
    private final BigDecimal amountAfterExchange;
    private final ExchangeStatus status;

    public ExchangeResponseDto(Exchange exchange) {
        this.amountInKrw = exchange.getAmountInKrw();
        this.amountAfterExchange = exchange.getAmountAfterExchange();
        this.status = exchange.getStatus();
    }
}
