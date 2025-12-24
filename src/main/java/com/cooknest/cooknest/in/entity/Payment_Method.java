package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment_Method")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment_Method
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_method_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String gateway;

    @Column
    private String token;

    @Column
    private String card_brand;

    @Column
    private int card_last_four_digit;

    @Column
    private int expiry_month;

    @Column
    private int expiry_year;

    @Column
    private boolean is_default;
}
