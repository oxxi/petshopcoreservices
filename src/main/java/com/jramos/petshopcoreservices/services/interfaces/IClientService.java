package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.ClienteModels;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface IClientService {

    Collection<ClienteModels> getAll();

    ClienteModels getById(long id);

    ClienteModels save(ClienteModels model);

    ClienteModels update(ClienteModels model);

    Collection<ClienteModels> updateBulk(List<ClienteModels> models);
}
