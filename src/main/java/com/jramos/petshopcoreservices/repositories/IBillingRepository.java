package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.entities.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillingRepository extends JpaRepository<BillingEntity, Long> {
}
