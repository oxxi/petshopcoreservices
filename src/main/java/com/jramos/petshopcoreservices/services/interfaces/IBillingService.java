package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.FacturaModels;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface IBillingService {

    void createBilling (FacturaModels model);

    FacturaModels getBillingById(Long id);

    Collection<FacturaModels> getBillingsByDate(Date init, Optional<Date> end);

    void updateBilling(FacturaModels models, Long id);
}
