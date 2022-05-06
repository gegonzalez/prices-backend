package com.example.prices.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int brandId;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private int priceList;

    @Column(nullable = false)
    private int productId;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private float fare;

    @Column(nullable = false)
    private String currency;

    public Price(int brandId, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productId, int priority, float fare, String currency) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.fare = fare;
        this.currency = currency;
    }
}
