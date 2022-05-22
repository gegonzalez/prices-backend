package com.example.prices.service;

import com.example.prices.entities.Price;
import com.example.prices.repository.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PriceServiceImpl.class);

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price fetchPrice(int brandId, int productId, LocalDateTime applicationDate) {
        var message = String.format("action=fetchPrice, class=PriceService, brandId=%d, productId=%d, applicationDate=%s", brandId, productId, applicationDate.toString());
        LOG.info(message);
        return priceRepository.findByProductIdAndBrandIdAndApplicationDate(brandId, productId, applicationDate)
                .stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow();
    }
}
