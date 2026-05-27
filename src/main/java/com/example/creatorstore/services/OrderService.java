package com.example.creatorstore.services;

import com.example.creatorstore.dto.OrderItemRequest;
import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.entities.OrderItem;
import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repositories.OrderRepository;
import com.example.creatorstore.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("Confirmed");

        for (OrderItemRequest orderItemRequest : orderRequest.getItems()) {

            Product product = productRepository.findById(orderItemRequest.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException("Product not found " + orderItemRequest.getProductId()));

            if (product.getStockQuantity() < orderItemRequest.getQuantity()) {
                throw new RuntimeException("Stock quantity less than order quantity");
            }

            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()));

            totalPrice = totalPrice.add(priceOfItem);

            product.setStockQuantity(
                    product.getStockQuantity() - orderItemRequest.getQuantity()
            );

            productRepository.save(product);

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(orderItemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }


}
