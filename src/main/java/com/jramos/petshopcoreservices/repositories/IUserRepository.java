package com.jramos.petshopcoreservices.repositories;

import com.jramos.petshopcoreservices.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
