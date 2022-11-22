package com.solverscrum.shopping.vo;

import lombok.Data;

@Data
public class ProductVo {
    private String productName;
    private int unit;
    private int price;
    private int supplierId;
}
