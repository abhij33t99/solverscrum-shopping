package com.solverscrum.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity @Table(name = "Shippers_10709423")
public class Shippers {
    @Id @Column @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int shipperId;
    @Column(length = 25)
    private String shipperName;
    @Column
    private int phone;

}