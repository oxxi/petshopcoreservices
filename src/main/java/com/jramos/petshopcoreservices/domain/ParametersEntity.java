package com.jramos.petshopcoreservices.domain;


import lombok.*;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "Parameters")
@Getter
@Setter
@NoArgsConstructor
public class ParametersEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private GeneralInfoEntity generalInfo;

    @NonNull
    private String name;

    @NonNull
    private String value;

    @NonNull
    private String description;

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof ParametersEntity)) return false;
        return id !=null && id.equals(((ParametersEntity) o).getId());
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}
