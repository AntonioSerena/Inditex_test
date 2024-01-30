package com.rest.inditex.repository;

import com.rest.inditex.entity.Prices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Prices, Long> {
    @Query(value = "SELECT * FROM PRICES WHERE PRODUCT_ID = :productId and BRAND_ID = :brandId" +
            " and START_DATE <= :applicationDate and END_DATE >= :applicationDate ORDER BY priority DESC", nativeQuery = true)
    List<Prices> findByApplicationDateTime(@Param("productId") String productID, @Param("brandId") long brandId,
                                           @Param("applicationDate") LocalDateTime applicationDate );
}