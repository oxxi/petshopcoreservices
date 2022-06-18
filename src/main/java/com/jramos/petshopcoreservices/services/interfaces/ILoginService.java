package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.LoginModel;

public interface ILoginService {

    boolean IsValid(LoginModel model);

    String GenerateToken(LoginModel model);
}
