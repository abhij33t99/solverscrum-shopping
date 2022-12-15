package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Products_10709423")
public class Products {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column
    private String productName;
    @Column
    private int unit;
    @Column
    private int price;
    @ManyToOne
    @JoinColumn(name = "supplierId") //@JsonManagedReference
    private Supplier supplier;

}