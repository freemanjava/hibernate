package com.freeman.hibernate.entities;

import javax.persistence.*;

@Entity
@Table
public class ClientWallet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @MapsId
    private Client client;
    @Column(name = "currency")
    private String currency;
    @Column(name = "amount")
    private Double amount;
}
