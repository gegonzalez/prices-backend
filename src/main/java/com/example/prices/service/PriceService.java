package com.example.prices.service;

import com.example.prices.domain.Price;
import com.example.prices.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PriceService.class);

    public Price fetchPrice(int brandId, int productId, LocalDateTime applicationDate) {
        LOG.info(getMessage(brandId, productId, applicationDate));
        return Optional.of(priceRepository.findByProductIdAndBrandIdAndApplicationDate(brandId, productId, applicationDate)
                        .stream()
                        .max(Comparator.comparing(Price::getPriority))
                        .orElseThrow())
                .get();
    }

    private String getMessage(int brandId, int productId, LocalDateTime applicationDate) {
        return String.format("action=fetchPrice, class=PriceService, brandId=%d, productId=%d, applicationDate=%s", brandId, productId, applicationDate.toString());
    }
}
