package com.example.ch4_user_currency.dto;

import com.example.ch4_user_currency.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    private String currencyName;
    private BigDecimal exchangeRate;
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}
