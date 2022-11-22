package com.solverscrum.shopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity @Table(name = "Suppliers_10709423")
public class Suppliers {
    @Id @Column @GeneratedValue(strategy = GenerationType.SEQUENCE)
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