package com.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter

@Table(name = "ProductType")
public class ProductTypeEntity {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "productType",cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<>();

    public void addProduct(ProductEntity product)
    {
        products.add(product);
        product.setProductType(this);
    }

    public void removeProduct(ProductEntity product)
    {
        products.remove(product);
        product.setProductType(null);
    }
}
