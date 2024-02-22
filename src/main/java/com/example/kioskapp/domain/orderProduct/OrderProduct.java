package com.example.kioskapp.domain.orderProduct;

import com.example.kioskapp.domain.BaseEntity;
import com.example.kioskapp.domain.order.Order;
import com.example.kioskapp.domain.product.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Builder
    private OrderProduct(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}
