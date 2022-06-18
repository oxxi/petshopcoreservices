package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.entities.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface IClientsRepository extends JpaRepository<ClientsEntity,Long> {

}
