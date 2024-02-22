package com.example.kioskapp.api.service.product.request;

import com.example.kioskapp.domain.product.Product;
import com.example.kioskapp.domain.product.ProductSellingStatus;
import com.example.kioskapp.domain.product.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateRequest {

    private ProductType type;

    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    @Builder
    private ProductCreateRequest(ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }

    public Product toEntity(String nextProductNumber) {
        return Product.builder()
                .productNumber(nextProductNumber)
                .name(this.name)
                .type(this.type)
                .sellingStatus(this.sellingStatus)
                .price(this.price)
                .build();
    }
}
