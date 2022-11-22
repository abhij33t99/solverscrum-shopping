package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailsVo {
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "Product ID is required")
    private int productId;
}
