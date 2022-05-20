package com.jramos.petshopcoreservices.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity

@Table(name = "General")
@Getter
@Setter
@NoArgsConstructor
public class GeneralInfoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
