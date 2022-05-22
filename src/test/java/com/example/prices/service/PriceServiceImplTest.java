package com.example.prices.service;

import com.example.prices.data.TestPrice;
import com.example.prices.entities.Price;
import com.example.prices.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {
    private static final int BRAND_ID = 1;
    private static final int PRODUCT_ID = 1234;
    private static final LocalDateTime APPLICATION_DATE = LocalDateTime.parse("2020-06-14T00:00:00");
    @Mock private transient PriceRepository priceRepository;
    @InjectMocks private transient PriceServiceImpl priceServiceImpl;

    @Test
    void shouldFetchPrice() {
        var expectedPricesList = List.of(TestPrice.price);
        when(priceRepository.findByProductIdAndBrandIdAndApplicationDate(BRAND_ID, PRODUCT_ID, APPLICATION_DATE))
                .thenReturn(expectedPricesList);

        Price priceList = priceServiceImpl.fetchPrice(BRAND_ID, PRODUCT_ID, APPLICATION_DATE);

        assertSame(expectedPricesList.get(0), priceList);
    }

    @Test
    void shouldThrowNoSuchElementException() {
        when(priceRepository.findByProductIdAndBrandIdAndApplicationDate(BRAND_ID, PRODUCT_ID, APPLICATION_DATE))
                .thenReturn(List.of());

        NoSuchElementException thrown = assertThrows(NoSuchElementException.class,
                                                    () -> priceServiceImpl.fetchPrice(BRAND_ID, PRODUCT_ID, APPLICATION_DATE),
                                            "NoSuchElementException was expected");
        assertEquals("No value present", thrown.getMessage());
    }
}