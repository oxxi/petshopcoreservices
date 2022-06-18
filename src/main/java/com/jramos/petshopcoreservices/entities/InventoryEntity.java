package com.jramos.petshopcoreservices.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



@Table(name = "Inventory")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class InventoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private LocalDateTime created;

    @Id
    private Long pdvId;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<>();

    @NonNull
    private String productName;
    @NonNull
    private double discount;
    @NonNull
    private boolean hasDiscount;

    @NonNull
    private boolean available;

    @NonNull
    private double price;

    @NonNull
    private Long volume;


    public void addProduct(ProductEntity product)
    {
        products.add(product);
        product.setInventory(this);
    }

    public void removeProduct(ProductEntity product)
    {
        products.remove(product);
        product.setInventory(null);
    }
}
