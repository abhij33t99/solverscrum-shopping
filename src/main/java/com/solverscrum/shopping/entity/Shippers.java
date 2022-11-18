package com.solverscrum.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "Shippers_10709423")
public class Shippers {
    @Id @Column @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperId;
    @Column(length = 25)
    private String shipperName;
    @Column
    private int phone;

}