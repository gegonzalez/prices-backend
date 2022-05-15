package com.example.prices.data;

import com.example.prices.entities.Price;

import java.time.LocalDateTime;

public class TestPrice {
    private static final int BRAND_ID = 1;
    private static final LocalDateTime START_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    private static final LocalDateTime END_DATE = LocalDateTime.parse("2020-12-31T23:59:59");
    private static final int PRICE_LIST = 100;
    private static final int PRODUCT_ID = 1234;
    private static final int PRIORITY = 1;
    private static final float FINAL_PRICE = 999F;
    private static final String CURRENCY = "EUR";
    public static final Price price = new Price(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, FINAL_PRICE, CURRENCY);
}