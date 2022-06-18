package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.CreateUsuarioModel;
import com.jramos.petshopcoreservices.Models.ResponseUsuarioModel;
import com.jramos.petshopcoreservices.repositories.IUserRepository;
import com.jramos.petshopcoreservices.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public ResponseUsuarioModel CreateUser(CreateUsuarioModel model) {
        return null;
    }

    @Override
    public ResponseUsuarioModel UpdateUser(CreateUsuarioModel model, Long id) {
        return null;
    }

    @Override
    public Collection<ResponseUsuarioModel> GetAll() {
        return null;
    }

    @Override
    public Collection<ResponseUsuarioModel> GetByRol(Long rolId) {
        return null;
    }

    @Override
    public ResponseUsuarioModel GetById(Long id) {
        return null;
    }
}
