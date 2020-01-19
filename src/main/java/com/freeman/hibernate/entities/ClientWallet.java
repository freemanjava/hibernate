package com.freeman.hibernate.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_wallet")
public class ClientWallet {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Client client;
    @Column(name = "currency")
    private String currency;
    @Column(name = "amount")
    private Double amount;

    public ClientWallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientWallet)) return false;
        ClientWallet that = (ClientWallet) o;
        return id.equals(that.id) &&
                Objects.equals(client, that.client) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, currency, amount);
    }
}
