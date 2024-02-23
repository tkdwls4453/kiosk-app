package com.example.kioskapp.api.service.product;

import com.example.kioskapp.api.service.product.request.ProductCreateServiceRequest;
import com.example.kioskapp.api.service.product.response.ProductResponse;
import com.example.kioskapp.domain.product.Product;
import com.example.kioskapp.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product savedProduct = request.toEntity(nextProductNumber);
        productRepository.save(savedProduct);

        return ProductResponse.of(savedProduct);
    }

    private String createNextProductNumber() {
        String lastProductNumber = productRepository.findLastProductNumber();

        if (lastProductNumber == null) {
            return "001";
        }

        int lastProductNumberInt = Integer.parseInt(lastProductNumber);
        String nextProductNumber = String.format("%03d", lastProductNumberInt + 1);

        return nextProductNumber;
    }
}
