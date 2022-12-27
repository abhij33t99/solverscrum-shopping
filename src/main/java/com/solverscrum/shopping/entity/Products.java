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
    private Integer productId;
    @Column
    private String productName;
    @Column
    private Integer unit;
    @Column
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "supplierId") //@JsonManagedReference
    private Supplier supplier;

}