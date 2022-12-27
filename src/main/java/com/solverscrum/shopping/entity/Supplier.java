package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Suppliers_10709423")
public class Supplier {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;
    @Column(length = 25)
    private String supplierName;
    @Column(length = 100)
    private String address;
    @Column(length = 25)
    private String city;
    @Column
    private Integer postalCode;
    @Column
    private Integer phone;
}