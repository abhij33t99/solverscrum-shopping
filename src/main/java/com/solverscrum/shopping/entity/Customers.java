package com.solverscrum.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter @AllArgsConstructor @ToString @NoArgsConstructor
@Entity
@Table(name = "Customers_10709423")
public class Customers {
    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
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