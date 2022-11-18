package com.solverscrum.shopping.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "Suppliers_10709423")
public class Suppliers {
    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    @Column(length = 25)
    private String supplierName;
    @Column(length = 100)
    private String address;
    @Column(length = 25)
    private String city;
    @Column
    private int postalCode;
    @Column
    private int phone;
//    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JsonManagedReference
//    private List<Products> products;
}