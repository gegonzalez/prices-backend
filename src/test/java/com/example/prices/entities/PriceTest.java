package com.example.prices.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PriceTest {
    private static final int BRAND_ID = 1;
    private static final LocalDateTime START_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    private static final LocalDateTime END_DATE = LocalDateTime.parse("2020-12-31T23:59:59");
    private static final int PRICE_LIST = 100;
    private static final int PRODUCT_ID = 1234;
    private static final int PRIORITY = 1;
    private static final float FINAL_PRICE = 999F;
    private static final String CURRENCY = "EUR";

    private final transient Price price = new Price(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, FINAL_PRICE, CURRENCY);

    @Test
    void shouldGetPriceCorrectly() {
        assertThat(price.getBrandId(), is(BRAND_ID));
        assertThat(price.getStartDate(), is(START_DATE));
        assertThat(price.getEndDate(), is(END_DATE));
        assertThat(price.getPriceList(), is(PRICE_LIST));
        assertThat(price.getProductId(), is(PRODUCT_ID));
        assertThat(price.getPriority(), is(PRIORITY));
        assertThat(price.getFinalPrice(), is(FINAL_PRICE));
        assertThat(price.getCurrency(), is(CURRENCY));
    }
}