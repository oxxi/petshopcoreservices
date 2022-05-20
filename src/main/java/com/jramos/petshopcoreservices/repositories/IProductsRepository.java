package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.domain.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<ProductEntity, Long> {


}


