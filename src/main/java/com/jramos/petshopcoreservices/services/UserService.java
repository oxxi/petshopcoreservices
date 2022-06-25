package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.CreateUsuarioModel;
import com.jramos.petshopcoreservices.Models.ResponseUsuarioModel;
import com.jramos.petshopcoreservices.entities.RolesEntity;
import com.jramos.petshopcoreservices.entities.UserEntity;
import com.jramos.petshopcoreservices.repositories.IUserRepository;
import com.jramos.petshopcoreservices.services.interfaces.IUserService;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public ResponseUsuarioModel CreateUser(CreateUsuarioModel model)
    {
        var entity = new UserEntity();
        entity.setFirstName(model.getNombre());
        entity.setUserName(model.getNombreUsuario());
        entity.setSurName(model.getApellido());
        entity.setEmail(model.getCorreo());

        var result =  new ResponseUsuarioModel().toResponseUsuario(model);
        var newUser= _userRepository.save(entity);
        result.setId(newUser.getId());
        result.setRolId(newUser.getRoles().stream().map(RolesEntity::getId).collect(Collectors.toList()));
        result.setRol(newUser.getRoles().stream().map(RolesEntity::getName).collect(Collectors.toList()));
        return result;
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
