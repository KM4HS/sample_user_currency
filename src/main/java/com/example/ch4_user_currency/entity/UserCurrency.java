package com.example.ch4_user_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.entity
 * <li>fileName       : UserCurrency
 * <li>date           : 24. 11. 28.
 * <li>description    : User와 Currency 중간 테이블
 * </ul>
 */

@Entity
@Getter
@Table(name = "user_currency")
public class UserCurrency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private BigDecimal amountInKrw;

    private BigDecimal amountAfterExchange;

    @Enumerated(value = EnumType.STRING)
    private UserCurrStatus status;
}
