package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailsVo {
    private Integer orderDetailsId;
    @NotNull(message = "quantity is required")
    private Integer quantity;
    @NotNull(message = "Product ID is required")
    private Integer productId;
    private ProductVo productVo;
}
