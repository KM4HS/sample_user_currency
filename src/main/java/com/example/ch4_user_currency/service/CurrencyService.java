package com.example.ch4_user_currency.service;

import com.example.ch4_user_currency.dto.CurrencyRequestDto;
import com.example.ch4_user_currency.dto.CurrencyResponseDto;
import com.example.ch4_user_currency.entity.Currency;
import com.example.ch4_user_currency.exception.CustomException;
import com.example.ch4_user_currency.exception.ErrorCode;
import com.example.ch4_user_currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResponseDto findById(Long id) {
        return new CurrencyResponseDto(findCurrencyById(id));
    }

    public Currency findCurrencyById(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.CURRENCY_NOT_FOUND));
    }

    public List<CurrencyResponseDto> findAll() {
        return currencyRepository.findAll().stream().map(CurrencyResponseDto::toDto).toList();
    }

    @Transactional
    public CurrencyResponseDto save(CurrencyRequestDto currencyRequestDto) {
        Currency savedCurrency = currencyRepository.save(currencyRequestDto.toEntity());
        return new CurrencyResponseDto(savedCurrency);
    }
}
