package com.jramos.petshopcoreservices.services.interfaces;

import java.util.List;

public interface IJwtService {

    String generateToken(String userName, String fullName, List<String> roles);
    boolean validateToken(String token);

    String getClaim(String token,String name);



}
