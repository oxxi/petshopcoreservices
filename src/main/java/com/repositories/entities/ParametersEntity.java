package com.repositories.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "Parameters")
@Entity
public class ParametersEntity {

    @Id
    @GeneratedValue
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
