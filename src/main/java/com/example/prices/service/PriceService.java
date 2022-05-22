package com.example.prices.service;

import com.example.prices.entities.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price fetchPrice(int brandId, int productId, LocalDateTime applicationDate);
}
