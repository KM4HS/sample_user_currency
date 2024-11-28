package com.example.ch4_user_currency.config;

import com.example.ch4_user_currency.entity.Currency;
import com.example.ch4_user_currency.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.config
 * <li>fileName       : DataInitializer
 * <li>date           : 24. 11. 28.
 * <li>description    : currency 데이터 초기화
 * </ul>
 */

@Slf4j
@Component
@Profile("dev")
public class DataInitializer {

    @Autowired
    private CurrencyRepository currencyRepository;

    @PostConstruct
    public void init() {
        Currency usd = new Currency("USD", new BigDecimal("1430.00"), "$");
        Currency test1 = new Currency("TEST", new BigDecimal("-1"), "*");

        currencyRepository.save(usd);
        currencyRepository.save(test1);

        log.info("======= add usd =======");

        List<Currency> lessThanZeros = currencyRepository.findCurrenciesByExchangeRateIsLessThanEqual(BigDecimal.ZERO);
        lessThanZeros.forEach(currency -> {
            log.info("{}: {}", currency.getCurrencyName(), currency.getExchangeRate());
            currencyRepository.delete(currency);
        });

        log.info("======= checked invalid currency =======");
    }
}
