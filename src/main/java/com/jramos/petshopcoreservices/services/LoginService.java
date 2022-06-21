package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.LoginModel;
import com.jramos.petshopcoreservices.repositories.IUserRepository;
import com.jramos.petshopcoreservices.services.interfaces.IJwtService;
import com.jramos.petshopcoreservices.services.interfaces.ILoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements ILoginService {


    private final IUserRepository _userRepository;
    private final IJwtService _jwtService;

    public LoginService(IUserRepository userRepository, IJwtService jwtService) {
        _userRepository = userRepository;
        _jwtService = jwtService;
    }

    @Override
    public boolean IsValid(LoginModel model) {
        return true;
    }

    @Override
    public String GenerateToken(LoginModel model) {
        List<String> roles = new ArrayList<>();
        roles.add("test");
        return _jwtService.generateToken(model.getUserName(),"Jose Ramos",roles);

    }
}
