package com.repositories.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor

@Table(name = "Inventory")
@Entity
@IdClass(InventoryEntity.class)
public class InventoryEntity implements Serializable {

    @Id
    @GeneratedValue
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
