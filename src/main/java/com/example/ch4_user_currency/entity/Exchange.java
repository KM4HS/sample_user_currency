package com.example.ch4_user_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.entity
 * <li>fileName       : Exchange
 * <li>date           : 24. 11. 28.
 * <li>description    : User와 Currency 사이 환전 요청을 나타내는 중간 테이블
 * </ul>
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "`exchange`")
public class Exchange extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(nullable = false)
    private BigDecimal amountInKrw;

    private BigDecimal amountAfterExchange;

    @Enumerated(value = EnumType.STRING)
    private ExchangeStatus status;

    public Exchange(User user, Currency currency, BigDecimal amountInKrw, BigDecimal amountAfterExchange, ExchangeStatus status) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public void cancelExchange() {
        this.status = ExchangeStatus.CANCELLED;
    }
}
