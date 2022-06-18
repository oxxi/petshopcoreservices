package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.CreateUsuarioModel;
import com.jramos.petshopcoreservices.Models.ResponseUsuarioModel;

import java.util.Collection;

public interface IUserService {

    ResponseUsuarioModel CreateUser(CreateUsuarioModel model);

    ResponseUsuarioModel UpdateUser(CreateUsuarioModel model, Long id);

    Collection<ResponseUsuarioModel> GetAll();

    Collection<ResponseUsuarioModel> GetByRol(Long rolId);

    ResponseUsuarioModel GetById(Long id);
}
