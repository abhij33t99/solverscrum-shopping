package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ShipperVo {
    private Integer shipperId;
    @NotNull(message = "Shipper's Name is required.")
    @Size(min = 4, message = "Shipper's Name must be atleast 4 characters.")
    private String shipperName;
    @NotNull(message = "Phone no. is required")
    @Min(100000)
    private Long phone;
}
