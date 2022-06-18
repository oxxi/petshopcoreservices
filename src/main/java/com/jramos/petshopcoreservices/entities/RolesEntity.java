package com.jramos.petshopcoreservices.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@ToString
public class RolesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String Name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
       CascadeType.PERSIST,
       CascadeType.MERGE
    }, mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();
}
