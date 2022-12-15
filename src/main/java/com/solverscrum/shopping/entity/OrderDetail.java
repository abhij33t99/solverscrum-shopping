package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "OrderDetails_10709423")
public class OrderDetail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;
    @Column
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;
}