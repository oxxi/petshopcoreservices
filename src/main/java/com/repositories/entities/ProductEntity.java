package com.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Getter
@Setter

@ToString()
@Table(name="Products")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @ManyToOne
    private ProductTypeEntity productType;

    @ManyToOne
    private InventoryEntity inventory;

    private String barCode;

    private boolean available;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    private byte[] photo;

    @NonNull
    private double volume;

    private String measure;

    @NonNull
    private LocalDateTime created;


}
