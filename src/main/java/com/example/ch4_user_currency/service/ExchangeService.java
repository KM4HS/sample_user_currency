package com.example.ch4_user_currency.service;

import com.example.ch4_user_currency.dto.ExchangeGroupResponseDto;
import com.example.ch4_user_currency.dto.ExchangeResponseDto;
import com.example.ch4_user_currency.entity.Currency;
import com.example.ch4_user_currency.entity.Exchange;
import com.example.ch4_user_currency.entity.ExchangeStatus;
import com.example.ch4_user_currency.entity.User;
import com.example.ch4_user_currency.exception.CustomException;
import com.example.ch4_user_currency.exception.ErrorCode;
import com.example.ch4_user_currency.repository.CurrencyRepository;
import com.example.ch4_user_currency.repository.ExchangeRepository;
import com.example.ch4_user_currency.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.service
 * <li>fileName       : ExchangeService
 * <li>date           : 24. 11. 28.
 * <li>description    : 환전 요청 비즈니스 로직
 * </ul>
 */

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final static List<String> HUNDRED_UNIT = Arrays.asList(new String[]{"JPY", "IDR", "VND", "KHR"});
    private final ExchangeRepository exchangeRepository;
    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;

    /**
     * 환전 요청 생성하는 비즈니스 로직. 환율을 적용한 값을 계산, 소수점 2자리로 반올림.
     *
     * @param userId      유저 식별자
     * @param currencyId  환율 식별자
     * @param amountInKrw 대한민국 원 크기
     */
    @Transactional
    public ExchangeResponseDto createExchange(Long userId, Long currencyId, BigDecimal amountInKrw) {

        User findUser = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        Currency findCurrency = currencyRepository.findById(currencyId).orElseThrow(() -> new CustomException(ErrorCode.CURRENCY_NOT_FOUND));
        BigDecimal amountAfterExchange = amountInKrw.divide(findCurrency.getExchangeRate(), 2, RoundingMode.UP);

        if (HUNDRED_UNIT.contains(findCurrency.getCurrencyName())) {
            amountAfterExchange = amountAfterExchange.multiply(BigDecimal.valueOf(100));
        }

        Exchange savedExchange = exchangeRepository.save(new Exchange(findUser, findCurrency, amountInKrw, amountAfterExchange, ExchangeStatus.NORMAL));
        return new ExchangeResponseDto(savedExchange);
    }

    /**
     * 유저별 환전 요청을 조회
     *
     * @param userId 유저 식별자
     */
    public List<ExchangeResponseDto> findExchangesByUser(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        List<Exchange> exchangesByUser = exchangeRepository.findExchangesByUser(findUser);

        return exchangesByUser.stream().map(ExchangeResponseDto::new).toList();
    }

    /**
     * 환전 요청의 상태를 취소로 전환
     *
     * @param exchangeId 환전 요청 식별자
     */
    @Transactional
    public void cancelExchange(Long exchangeId) {
        Exchange findExchange = exchangeRepository.findById(exchangeId).orElseThrow(() -> new CustomException(ErrorCode.EXCHANGE_NOT_FOUND));
        findExchange.cancelExchange();
        exchangeRepository.save(findExchange);
    }

    /**
     * 유저의 환전 요청을 그룹화
     *
     * @param sessionKey 유저 식별자
     */
    public ExchangeGroupResponseDto findExchangeInGroup(Long sessionKey) {
        int count = exchangeRepository.countExchangesByUserId(sessionKey);
        BigDecimal totalAfterExchange = exchangeRepository.getTotalAmountInKrw(sessionKey);

        return new ExchangeGroupResponseDto(count, totalAfterExchange);
    }
}
