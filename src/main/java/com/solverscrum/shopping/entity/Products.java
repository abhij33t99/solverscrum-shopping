package com.solverscrum.shopping.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity @Table(name = "Products_10709423")
public class Products {
    @Id @Column @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;
    @Column
    private String productName;
    @Column
    private int unit;
    @Column
    private int price;
    @ManyToOne @JoinColumn(name = "supplierId") //@JsonManagedReference
    private Suppliers supplier;

}