package com.altran.manuelstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private double price;

    @Column
    private int quantity;
}
