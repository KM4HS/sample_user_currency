package com.example.ch4_user_currency.repository;

import com.example.ch4_user_currency.entity.User;
import com.example.ch4_user_currency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.repository
 * <li>fileName       : ExchangeRepository
 * <li>date           : 24. 11. 28.
 * <li>description    : 환전 요청 레포지토리
 * </ul>
 */

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    List<Exchange> findExchangesByUser(User findUser);
}
