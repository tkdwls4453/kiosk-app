package com.example.kioskapp.api.service.product.request;

import com.example.kioskapp.api.controller.product.dto.request.ProductCreateRequest;
import com.example.kioskapp.domain.product.Product;
import com.example.kioskapp.domain.product.ProductSellingStatus;
import com.example.kioskapp.domain.product.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCreateServiceRequest {

    private ProductType type;

    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    @Builder
    private ProductCreateServiceRequest(ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
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

    public static ProductCreateServiceRequest of(ProductCreateRequest request) {
        return ProductCreateServiceRequest.builder()
                .name(request.getName())
                .price(request.getPrice())
                .type(request.getType())
                .sellingStatus(request.getSellingStatus())
                .build();
    }
}
