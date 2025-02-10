package com.example.GameStore.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_WALLET")
public class Wallet implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 4, scale = 2)
    private BigDecimal amount;
    @Column(name = "points", nullable = false)
    private Long points;

    public Wallet(){}

    public Wallet(BigDecimal amount, Long points) {
        this.amount = amount;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(amount, wallet.amount) && Objects.equals(points, wallet.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, points);
    }
}
