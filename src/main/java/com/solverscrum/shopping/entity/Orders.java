package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orders_10709423")
public class Orders {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customers customer;
    @ManyToOne
    @JoinColumn(name = "shipperId")
    private Shippers shipper;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private List<OrderDetails> orderDetails;
}