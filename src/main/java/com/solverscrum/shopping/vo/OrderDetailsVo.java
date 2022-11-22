package com.solverscrum.shopping.vo;

import lombok.Data;

@Data
public class OrderDetailsVo {
    private int quantity;
    private int orderId;
    private int productId;
}
