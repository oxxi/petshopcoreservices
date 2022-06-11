package com.jramos.petshopcoreservices.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name = "ProductType")
@NoArgsConstructor
@Getter
@Setter
public class ProductTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String description;



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


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
