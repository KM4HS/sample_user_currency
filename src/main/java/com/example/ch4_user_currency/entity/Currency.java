package com.example.ch4_user_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Currency extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String currencyName;

    @Column(nullable = false)
    private BigDecimal exchangeRate;

    @Column(length = 10)
    private String symbol;

    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    private List<Exchange> exchanges = new ArrayList<>();

    public Currency(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public Currency() {
    }
}
