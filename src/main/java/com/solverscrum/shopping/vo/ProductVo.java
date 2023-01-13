package com.solverscrum.shopping.vo;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProductVo {
    private Integer productId;
    @NotNull(message = "Product Name is required")
    private String productName;
    @NotNull(message = "Unit is required")
    @Min(1)
    private Integer unit;
    @NotNull(message = "Price is required")
    @Min(1)
    private Integer price;
    @NotNull(message = "Supplier ID is required")
    private Integer supplierId;
    @NotNull(message = "Image url is required")
    private String imgUrl;
    private SupplierVo supplier;
}
