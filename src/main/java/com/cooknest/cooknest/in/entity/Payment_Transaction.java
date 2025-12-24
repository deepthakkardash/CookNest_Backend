package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment_Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment_Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_transaction_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private String gateway;

    @Column
    private int transaction_id;

    @Column
    private int amount;

    @Column
    private String status;
}
