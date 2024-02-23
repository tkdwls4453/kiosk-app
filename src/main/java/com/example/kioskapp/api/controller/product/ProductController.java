package com.example.kioskapp.api.controller.product;

import com.example.kioskapp.api.ApiResponse;
import com.example.kioskapp.api.controller.product.dto.request.ProductCreateRequest;
import com.example.kioskapp.api.service.product.ProductService;
import com.example.kioskapp.api.service.product.request.ProductCreateServiceRequest;
import com.example.kioskapp.api.service.product.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/v1/products/new")
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductCreateRequest request){
        return ApiResponse.ok(productService.createProduct(ProductCreateServiceRequest.of(request)));
    }
}
