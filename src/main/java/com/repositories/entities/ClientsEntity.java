package com.repositories.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "Clients")
@Entity
public class ClientsEntity {

    @Id
    @GeneratedValue
    private Long Id;

    @NonNull
    private String firstName;

    @NonNull
    private String secondName;

    private long phoneNumber;

    private String email;

    private String otherPhoneNumbers;

    private LocalDateTime created;
}
