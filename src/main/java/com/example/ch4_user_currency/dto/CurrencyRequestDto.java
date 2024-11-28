package com.example.ch4_user_currency.dto;

import com.example.ch4_user_currency.entity.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {

    @NotBlank(message = "환율 명을 입력해주세요.")
    private String currencyName;

    @NotNull(message = "환율을 입력해주세요.")
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
