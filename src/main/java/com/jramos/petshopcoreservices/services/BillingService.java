package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.FacturaModels;
import com.jramos.petshopcoreservices.repositories.IBillingRepository;
import com.jramos.petshopcoreservices.services.interfaces.IBillingService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class BillingService  implements IBillingService {

    private final IBillingRepository _billingRepository;

    public BillingService(IBillingRepository billingRepository) {
        _billingRepository = billingRepository;
    }

    @Override
    public void createBilling(FacturaModels model) {

    }

    @Override
    public FacturaModels getBillingById(Long id) {
        return null;
    }

    @Override
    public Collection<FacturaModels> getBillingsByDate(Date init, Optional<Date> end) {
        return null;
    }

    @Override
    public void updateBilling(FacturaModels models, Long id) {

    }
}
