package com.example.prices.controller.transformers;

import com.example.prices.entities.Price;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PriceResponseTransformerTest {

    private static final int BRAND_ID = 1;
    public static final LocalDateTime START_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    public static final LocalDateTime END_DATE = LocalDateTime.parse("2020-12-31T23:59:59");
    private static final int PRICE_LIST = 100;
    private static final int PRODUCT_ID = 1234;
    private static final int PRIORITY = 1;
    private static final float FINAL_PRICE = 999F;
    private static final String CURRENCY = "EUR";

    private final Price price = new Price(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, FINAL_PRICE, CURRENCY);

    @Test
    void shouldTransformPriceToPriceResponse() {
        var priceResponse = PriceResponseTransformer.from(price);

        assertThat(priceResponse.getBrandId(), is(BRAND_ID));
        assertThat(priceResponse.getStartDate(), is(START_DATE));
        assertThat(priceResponse.getEndDate(), is(END_DATE));
        assertThat(priceResponse.getPriceList(), is(PRICE_LIST));
        assertThat(priceResponse.getProductId(), is(PRODUCT_ID));
        assertThat(priceResponse.getFinalPrice(), is(FINAL_PRICE));
        assertThat(priceResponse.getCurrency(), is(CURRENCY));
    }
}