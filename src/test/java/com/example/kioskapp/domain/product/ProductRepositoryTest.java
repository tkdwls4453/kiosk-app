package com.example.kioskapp.domain.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("마지막 상품의 상품 번호를 읽어온다.")
    @Test
    void findLastProductNumber(){
        // Given
        Product product = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingStatus(ProductSellingStatus.SELLING)
                .name("아메리카노")
                .price(4000)
                .build();

        productRepository.save(product);

        // When
        String result = productRepository.findLastProductNumber();

        // Then
        assertThat(result).isEqualTo("001");
    }

    @DisplayName("가장 마지막 상품 번호를 조회할 때, 상품이 하나도 없는 경우에는 null 을 반환한다.")
    @Test
    void findLastProductNumberWhenProductIsEmpty(){
        // When
        String result = productRepository.findLastProductNumber();

        // Then
        assertThat(result).isNull();
    }
}