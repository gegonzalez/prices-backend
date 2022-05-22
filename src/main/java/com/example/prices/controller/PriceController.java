package com.example.prices.controller;

import com.example.prices.controller.response.PriceResponse;
import com.example.prices.controller.transformers.PriceResponseTransformer;
import com.example.prices.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private transient PriceService priceService;

    private static final Logger LOG = LoggerFactory.getLogger(PriceController.class);

    @GetMapping("{brandId}/{productId}/{applicationDate}")
    public ResponseEntity<PriceResponse> fetchPrice(@PathVariable("brandId") int brandId,
                                                    @PathVariable("productId") int productId,
                                                    @PathVariable("applicationDate") String applicationDate) {
        var message = String.format("action=fetchPrice, class=PriceController, brandId=%d, productId=%d, applicationDate=%s", brandId, productId, applicationDate);
        LOG.info(message);
        var priceResult = priceService.fetchPrice(brandId, productId, LocalDateTime.parse(applicationDate));
        LOG.info("status=success");
        return ResponseEntity.ok(PriceResponseTransformer.from(priceResult));
    }
}
