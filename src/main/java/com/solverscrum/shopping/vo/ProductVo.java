package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProductVo {
    @NotNull(message = "Product Name is required")
    private String productName;
    @NotNull(message = "Unit is required") @Min(1)
    private int unit;
    @NotNull(message = "Price is required") @Min(1)
    private int price;
    @NotNull(message = "Supplier ID is required")
    private int supplierId;
}
