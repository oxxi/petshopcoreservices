package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.LoginModel;
import com.jramos.petshopcoreservices.repositories.IUserRepository;
import com.jramos.petshopcoreservices.services.interfaces.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {


    private final IUserRepository _userRepository;

    public LoginService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public boolean IsValid(LoginModel model) {
        return false;
    }

    @Override
    public String GenerateToken(LoginModel model) {
        return null;
    }
}
