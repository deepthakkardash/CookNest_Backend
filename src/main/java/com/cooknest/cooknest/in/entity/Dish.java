package com.cooknest.cooknest.in.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dish")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dish_id;

    @Column
    private String dish_name;

    @Column
    private int price;

    @Column
    private boolean is_veg;

    @Column
    private String image_url;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
