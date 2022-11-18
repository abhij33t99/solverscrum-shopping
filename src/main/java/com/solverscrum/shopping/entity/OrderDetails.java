package com.solverscrum.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter @Setter @AllArgsConstructor
@Entity @Table(name = "OrderDetails_10709423")
public class OrderDetails {
    @Id @Column
    private int orderDetailsId;
    @Column
    private int quantity;
    @ManyToOne @JoinColumn(name = "orderId")
    private Orders order;
    @ManyToOne @JoinColumn(name = "productId")
    private Products product;
}