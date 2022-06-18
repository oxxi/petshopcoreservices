package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.entities.ProductTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {
}
