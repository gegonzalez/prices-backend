package com.example.prices.controller.transformers;

import com.example.prices.controller.response.PriceResponse;
import com.example.prices.domain.Price;

public class PriceResponseTransformer {
    public static PriceResponse from(final Price price) {
        return PriceResponse.builder()
                .brandId(price.getBrandId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .priceList(price.getPriceList())
                .productId(price.getProductId())
                .finalPrice(price.getFinalPrice())
                .currency(price.getCurrency())
                .build();
    }

    private PriceResponseTransformer() {}
}
