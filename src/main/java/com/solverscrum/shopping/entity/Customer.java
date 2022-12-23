package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Customers_10709423")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Column(length = 25)
    private String customerName;
    @Column(length = 100)
    private String address;
    @Column(length = 25)
    private String city;
    @Column
    private int postalCode;
    @Column(length = 25)
    private String country;
//    @OneToMany(mappedBy = "customer")
//    private List<Orders> orders;
}