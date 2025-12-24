package com.cooknest.cooknest.in.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String type;

    @Column
    private String label;

    @Column
    private String line1;

    @Column
    private String line2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pincode;

    @Column
    private String country;

}
