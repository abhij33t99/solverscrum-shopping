package com.solverscrum.shopping.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "Products_10709423")
public class Products {
    @Id @Column @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column
    private String productName;
    @Column
    private int unit;
    @Column
    private int price;
    @ManyToOne @JoinColumn(name = "supplierId") //@JsonBackReference
    private Suppliers supplier;

}