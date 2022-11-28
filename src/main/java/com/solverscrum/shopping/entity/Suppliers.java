package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Suppliers_10709423")
public class Suppliers {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    @Column(length = 25)
    private String supplierName;
    @Column(length = 100)
    private String address;
    @Column(length = 25)
    private String city;
    @Column
    private int postalCode;
    @Column
    private int phone;
//    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JsonBackReference
//    private List<Products> products;
}