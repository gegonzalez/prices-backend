package com.example.prices.repository;

import com.example.prices.entities.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    @Query("FROM Price p WHERE p.brandId = ?1 AND p.productId = ?2 AND p.startDate <= ?3 AND p.endDate >= ?3 ")
    List<Price> findByProductIdAndBrandIdAndApplicationDate(int brandId, int productId, LocalDateTime applicationDate);
}
