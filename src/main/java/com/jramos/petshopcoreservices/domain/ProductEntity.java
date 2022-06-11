package com.jramos.petshopcoreservices.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;




@Entity

@Table(name="Products")
@NoArgsConstructor
@Getter
@Setter
@ToString()
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @CreationTimestamp
    private LocalDateTime created;


}