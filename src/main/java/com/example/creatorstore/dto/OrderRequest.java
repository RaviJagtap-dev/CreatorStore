package com.example.creatorstore.dto;

import com.example.creatorstore.entities.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderRequest {

    @NotNull(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Email is required")
    @Email(message = "Enter a valid pattern")
    private String customerEmail;

    @Valid
    @NotNull(message = "Order Items contains at least one item")
    private List<OrderItemRequest> orderItems;

}
