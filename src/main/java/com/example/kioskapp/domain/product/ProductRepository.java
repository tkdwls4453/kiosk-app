package com.example.kioskapp.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.product_number from product p order by id desc limit 1", nativeQuery = true)
    String findLastProductNumber();
}
