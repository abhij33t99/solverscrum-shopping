package com.solverscrum.shopping.vo;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class OrderVo {
    private int orderId;
    @NotNull(message = "Date is required")
    @Pattern(regexp = "^(2[0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|[3][01])", message = "date should be in yyyy-mm-dd format and should be valid")
    private String orderDate;
    @NotNull(message = "Customer Id is required")
    private int customerId;
    @NotNull(message = "Shipper Id is required")
    private int shipperId;
    @NotNull(message = " is required")
    private List<OrderDetailsVo> orderDetailsVo;
    private CustomerVo customer;
    private ShipperVo shipper;
}
