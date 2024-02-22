package com.example.kioskapp.api.service.product;

import com.example.kioskapp.api.service.product.request.ProductCreateRequest;
import com.example.kioskapp.api.service.product.response.ProductResponse;
import com.example.kioskapp.domain.product.Product;
import com.example.kioskapp.domain.product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.kioskapp.domain.product.ProductSellingStatus.SELLING;
import static com.example.kioskapp.domain.product.ProductType.HANDMADE;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("신규 상품을 등록한다. 상품번호는 가장 최근 상품의 상품번호에서 1 증가한 값이다.")
    @Test
    void createProduct(){
        // Given
        Product product = Product.builder()
                .productNumber("001")
                .type(HANDMADE)
                .sellingStatus(SELLING)
                .name("아메리카노")
                .price(4000)
                .build();

        productRepository.save(product);

        ProductCreateRequest request = ProductCreateRequest.builder()
                .type(HANDMADE)
                .sellingStatus(SELLING)
                .name("카푸치노")
                .price(5000)
                .build();
        // When
        ProductResponse productResponse = productService.createProduct(request);

        // Then
        assertThat(productResponse)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .contains("002", HANDMADE, SELLING, "카푸치노", 5000);

        List<Product> products = productRepository.findAll();

        assertThat(products).hasSize(2)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", HANDMADE, SELLING, "아메리카노", 4000),
                        tuple("002", HANDMADE, SELLING, "카푸치노", 5000)
                );
    }

    @DisplayName("상품이 하나도 없는 경우 신규 상품을 등록하면 상품 번호는 001 이다.")
    @Test
    void createProduct2(){
        // Given
        ProductCreateRequest request = ProductCreateRequest.builder()
                .type(HANDMADE)
                .sellingStatus(SELLING)
                .name("카푸치노")
                .price(5000)
                .build();

        // When
        ProductResponse productResponse = productService.createProduct(request);

        // Then
        assertThat(productResponse)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .contains("001", HANDMADE, SELLING, "카푸치노", 5000);

        List<Product> products = productRepository.findAll();

        assertThat(products).hasSize(1)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", HANDMADE, SELLING, "카푸치노", 5000)
                        );
    }
}