package com.solverscrum.shopping.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderVo {
    private Date orderDate;
    private int customerId;
    private int shipperId;
    private List<OrderDetailsVo> orderDetailsVo;
}
