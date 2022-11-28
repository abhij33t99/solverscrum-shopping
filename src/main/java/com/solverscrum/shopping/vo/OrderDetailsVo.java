package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailsVo {
    private int orderDetailsId;
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "Product ID is required")
    private int productId;
    private ProductVo productVo;
}
