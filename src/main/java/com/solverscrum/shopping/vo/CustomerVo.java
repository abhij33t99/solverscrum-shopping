package com.solverscrum.shopping.vo;

import lombok.Data;

@Data
public class CustomerVo {
    private String customerName;
    private String address;
    private String city;
    private int postalCode;
    private String country;
}
