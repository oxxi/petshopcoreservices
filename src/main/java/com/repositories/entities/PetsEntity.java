package com.repositories.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString()

@Table(name = "Pets")
@Entity
public class PetsEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long ownerId;

    @NonNull
    private int typeId;

    @NonNull
    private LocalDateTime birthday;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    private byte[] photo;

    @NonNull
    private int status;

    @NonNull
    private LocalDateTime created;
}
