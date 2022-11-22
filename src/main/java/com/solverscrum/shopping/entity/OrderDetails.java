package com.solverscrum.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Data
@Entity @Table(name = "OrderDetails_10709423")
public class OrderDetails {
    @Id @Column @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int orderDetailsId;
    @Column
    private int quantity;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Orders order;
    @ManyToOne @JoinColumn(name = "productId")
    private Products product;
}