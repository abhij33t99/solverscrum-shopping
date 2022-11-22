package com.solverscrum.shopping.vo;

import com.solverscrum.shopping.entity.Products;
import lombok.Data;

import java.util.List;

@Data
public class SupplierVo {
    private String supplierName;
    private String address;
    private String city;
    private int postalCode;
    private int phone;
    private List<Products> products;

}
