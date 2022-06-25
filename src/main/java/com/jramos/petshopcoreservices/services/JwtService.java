package com.jramos.petshopcoreservices.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jramos.petshopcoreservices.services.interfaces.IJwtService;
import org.springframework.stereotype.Service;


import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class JwtService implements IJwtService {

    private final Algorithm algorithm;
    private final  JWTVerifier verifier;



    public JwtService(){
        algorithm = Algorithm.HMAC512("TestSecret");
        verifier = JWT.require(algorithm).withIssuer("bootspring").build();

    }

    @Override
    public String generateToken(String userName, String fullName, List<String> roles) {
        UUID uuid = UUID.randomUUID();
        //1h 3600sec
        //4h 14400sec
        //6h 21600sec
        try{
            var lengthRoles = roles.size();
             return JWT.create()
                              .withJWTId(uuid.toString())
                              .withIssuer("bootspring")
                              .withClaim("name",userName)
                              .withClaim("fullName", fullName)
                              .withArrayClaim("rol",roles.toArray(new String[lengthRoles]))
                              .withIssuedAt(Date.from(Instant.now(Clock.systemUTC())))//TODO: Buscar solución mas factible as fecha GMT-6
                              .withExpiresAt(Date.from(Instant.now(Clock.systemUTC()).plusSeconds(3600)))
                              .sign(algorithm);


        }catch (JWTCreationException ex){
            throw new RuntimeException("Error al crear el token");
        }
    }

    @Override
    public boolean validateToken(String token) {

        try{
             verifier.verify(token);
            return true;
        }catch (JWTVerificationException exception){
           throw new JWTVerificationException("Invalid Token.");

        }
    }

    @Override
    public String getClaim(String token,String name) {

        try {
            DecodedJWT jwt = verifier.verify(token);
            Claim claim = jwt.getClaim(name);
            return claim.toString();
        }catch (Exception ex){
            throw new RuntimeException("error al extraer claim");
        }

    }
}
