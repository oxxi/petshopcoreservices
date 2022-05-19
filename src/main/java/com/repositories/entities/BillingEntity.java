package com.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "Billing")
@Entity
public class BillingEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private LocalDateTime created;

    private String rtnClient;

    private String clientName;

    @NonNull
    private double iva;

    @NonNull
    private String authorizationRange;

    @NonNull
    private LocalDate maxRange;

    private String paymentMethod;


    @OneToMany(mappedBy = "billing", cascade = CascadeType.ALL)
    private Set<BillingDetailEntity> billingDetails = new HashSet<>();

    public void addBillingDetail(BillingDetailEntity billingDetail)
    {
        billingDetails.add(billingDetail);
        billingDetail.setBilling(this);
    }

    public void removeBillingDetail(BillingDetailEntity detail)
    {
        billingDetails.remove(detail);
        detail.setBilling(null);
    }
}
