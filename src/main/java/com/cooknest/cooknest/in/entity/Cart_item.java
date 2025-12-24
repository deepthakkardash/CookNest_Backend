package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart_item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_item_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column
    private int quantity;

    @Column
    private int price;
}
