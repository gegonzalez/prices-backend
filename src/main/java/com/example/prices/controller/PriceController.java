package com.example.prices.controller;

import com.example.prices.controller.response.PriceResponse;
import com.example.prices.controller.transformers.PriceResponseTransformer;
import com.example.prices.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/prices")
@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    private static final Logger LOG = LoggerFactory.getLogger(PriceController.class);

    @GetMapping("{brandId}/{productId}/{application-date}")
    public ResponseEntity<PriceResponse> fetchPrice(@PathVariable("brandId") int brandId,
                                                    @PathVariable("productId") int productId,
                                                    @PathVariable("application-date") String applicationDate) {
        LOG.info(getMessage(brandId, productId, applicationDate));
        var priceResult = priceService.fetchPrice(brandId, productId, LocalDateTime.parse(applicationDate));
        if (priceResult.isPresent()) {
            LOG.info("status=success");
            return ResponseEntity.ok(PriceResponseTransformer.from(priceResult.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private String getMessage(int brandId, int productId, String applicationDate) {
        return String.format("action=fetchPrice, class=PriceController, brandId=%d, productId=%d, applicationDate=%s", brandId, productId, applicationDate);
    }
}
