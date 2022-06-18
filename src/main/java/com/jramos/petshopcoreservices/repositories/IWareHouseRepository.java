package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.entities.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWareHouseRepository extends JpaRepository<WareHouseEntity, Long> {
}
