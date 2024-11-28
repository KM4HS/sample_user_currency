package com.example.ch4_user_currency.repository;

import com.example.ch4_user_currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findCurrenciesByExchangeRateIsLessThanEqual(BigDecimal exchangeRate);
}
