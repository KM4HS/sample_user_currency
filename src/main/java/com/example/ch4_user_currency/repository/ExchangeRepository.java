package com.example.ch4_user_currency.repository;

import com.example.ch4_user_currency.entity.Exchange;
import com.example.ch4_user_currency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
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

    /**
     * 유저의 환전 요청 횟수를 count
     */
    @Query("SELECT COUNT(e.id) FROM Exchange e WHERE e.user.id = :userId")
    int countExchangesByUserId(@Param("userId") Long userId);

    /**
     * 유저가 환전을 요청한 총 금액(krw)을 더함
     */
    @Query("SELECT SUM(e.amountInKrw) FROM Exchange e WHERE e.user.id = :userId")
    BigDecimal getTotalAmountInKrw(@Param("userId") Long userId);
}
