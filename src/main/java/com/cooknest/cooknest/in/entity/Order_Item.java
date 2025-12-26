package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order_Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_item_id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column
    private int quantity;

    @Column
    private int price;
}
