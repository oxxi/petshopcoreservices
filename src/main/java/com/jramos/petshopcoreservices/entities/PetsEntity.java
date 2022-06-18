package com.jramos.petshopcoreservices.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;




@Entity
@Table(name = "Pets")
@Getter
@Setter
@NoArgsConstructor
@ToString()
public class PetsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

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

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private ClientsEntity client;


}
