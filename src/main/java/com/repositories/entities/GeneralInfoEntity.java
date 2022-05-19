package com.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "General")
@Entity
public class GeneralInfoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String address;

    @NonNull
    private String cai;

    @NonNull String rtn;

    @NonNull
    private String pdvName;

    private String phoneNumber;

    private String email;

    private String twitter;

    private String facebook;

    private String instagram;

    private byte[] hash;

    @OneToMany(mappedBy = "generalInfo", cascade = CascadeType.ALL)
    private Set<ParametersEntity> parameters = new HashSet<>();


    public void addParameter(ParametersEntity params)
    {
        parameters.add(params);
        params.setGeneralInfo(this);
    }

    public void removeParameter(ParametersEntity params)
    {
        parameters.remove(params);
        params.setGeneralInfo(null);
    }
}
