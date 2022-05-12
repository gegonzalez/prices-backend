package com.example.prices.service;

import com.example.prices.data.TestPrice;
import com.example.prices.domain.Price;
import com.example.prices.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    private static final int BRAND_ID = 1;
    private static final int PRODUCT_ID = 1234;
    private static final LocalDateTime APPLICATION_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    @Mock private PriceRepository priceRepository;
    @InjectMocks private PriceService priceService;

    @Test
    void shouldFetchPrice() {
        var expectedPricesList = List.of(TestPrice.price);
        when(priceRepository.findByProductIdAndBrandIdAndApplicationDate(BRAND_ID, PRODUCT_ID, APPLICATION_DATE))
                .thenReturn(expectedPricesList);

        Price priceList = priceService.fetchPrice(BRAND_ID, PRODUCT_ID, APPLICATION_DATE);

        assertSame(expectedPricesList.get(0), priceList);
    }
}