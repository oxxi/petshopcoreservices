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
@Table(name = "Users")
@Getter
@Setter
@ToString
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "Campo requerido")
    private String FirstName;

    @NotNull(message = "Campo requerido")
    private String SurName;

    @NotNull(message = "Campo requerido")
    private String UserName;

    @NotNull(message = "Campo requerido")
    private Byte[] Password;

    private String Email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RolesEntity> roles = new HashSet<>();


}
