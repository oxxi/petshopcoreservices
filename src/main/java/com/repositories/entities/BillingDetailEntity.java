package com.repositories.entities;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "BillingDetail")
@Entity
public class BillingDetailEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private String productName;

    private double unitPrice;

    private Long volume;

    private double discount;

    @ManyToOne()
    private BillingEntity billing;


    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof BillingDetailEntity)) return false;
        return id !=null && id.equals(((BillingEntity) o).getId());
    }

    @Override
    public int hashCode()
    {
        return  getClass().hashCode();
    }
}
