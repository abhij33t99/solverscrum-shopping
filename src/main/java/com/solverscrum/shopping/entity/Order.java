package com.solverscrum.shopping.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orders_10709423")
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "shipperId")
    private Shipper shipper;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private List<OrderDetail> orderDetails;
}