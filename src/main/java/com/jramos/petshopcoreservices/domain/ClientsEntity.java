package com.jramos.petshopcoreservices.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name="Clients")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientsEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    private String firstName;

    @NonNull
    private String secondName;

    private long phoneNumber;


    private String email;

    private String otherPhoneNumbers;
    @CreationTimestamp
    private LocalDateTime created;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<PetsEntity> pets;



}
