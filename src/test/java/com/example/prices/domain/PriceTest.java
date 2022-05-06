package com.example.prices.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PriceTest {
    private static final int BRAND_ID = 1;
    public static final LocalDateTime START_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    public static final LocalDateTime END_DATE = LocalDateTime.parse("2020-12-31T23:59:59");
    private static final int PRICE_LIST = 100;
    private static final int PRODUCT_ID = 1234;
    private static final int PRIORITY = 1;
    private static final float fare = Float.valueOf(999);
    private static final String CURRENCY = "EUR";

    private final Price price = new Price(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, fare, CURRENCY);

    @Test
    void shouldGetPriceCorrectly() {
        assertThat(price.getBrandId(), is(BRAND_ID));
        assertThat(price.getStartDate(), is(START_DATE));
        assertThat(price.getEndDate(), is(END_DATE));
        assertThat(price.getPriceList(), is(PRICE_LIST));
        assertThat(price.getProductId(), is(PRODUCT_ID));
        assertThat(price.getPriority(), is(PRIORITY));
        assertThat(price.getFare(), is(fare));
        assertThat(price.getCurrency(), is(CURRENCY));
    }
}