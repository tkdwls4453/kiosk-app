package com.example.kioskapp.api.service.product.response;

import com.example.kioskapp.domain.product.ProductSellingStatus;
import com.example.kioskapp.domain.product.ProductType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private Long id;

    private String productNumber;

    private ProductType type;

    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    @Builder
    private ProductResponse(String productNumber, ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}
