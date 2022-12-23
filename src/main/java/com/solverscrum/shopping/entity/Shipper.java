package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Shippers_10709423")
public class Shipper {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shipperId;
    @Column(length = 25)
    private String shipperName;
    @Column
    private int phone;

}