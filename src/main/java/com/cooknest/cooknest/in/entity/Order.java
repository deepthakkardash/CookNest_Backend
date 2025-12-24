package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int total_amount;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address deliver_address;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address billing_address;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private Payment_Method payment_method;



}
