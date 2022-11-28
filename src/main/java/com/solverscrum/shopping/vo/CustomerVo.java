package com.solverscrum.shopping.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerVo {
    private int customerId;
    @NotNull(message = "Customer Name is required")
    @Size(min = 4, message = "Customer Name should be atleast 4 characters or more")
    private String customerName;
    @NotNull(message = "Address is required")
    @Size(min = 5, max = 25)
    private String address;
    @NotNull(message = "City is required")
    private String city;
    @NotNull(message = "Postal Code is required")
    @Min(value = 100000, message = "Must be 6 digits")
    @Max(value = 999999, message = "Must be 6 digits")
    private int postalCode;
    @NotNull(message = "Country is required")
    private String country;
}
