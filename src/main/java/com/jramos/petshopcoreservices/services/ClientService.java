package com.jramos.petshopcoreservices.services;


import com.jramos.petshopcoreservices.Models.ClienteModels;

import com.jramos.petshopcoreservices.entities.ClientsEntity;
import com.jramos.petshopcoreservices.repositories.IClientsRepository;
import com.jramos.petshopcoreservices.services.interfaces.IClientService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    private final IClientsRepository _clientRepository;

    public ClientService(IClientsRepository clientRepository) {
        _clientRepository = clientRepository;
    }

    @Override
    public Collection<ClienteModels> getAll() {

        return  _clientRepository.findAll().stream().map(x-> {
            ClienteModels model = new ClienteModels();
            model.setFirstName(x.getFirstName());
            model.setLastName(x.getSecondName());
            model.setPhoneNumbers(x.getOtherPhoneNumbers() );
            model.setPrincipalPhoneNumber(String.valueOf(x.getPhoneNumber()));
            model.setId(x.getId().intValue());
            return model;
        }).collect(Collectors.toList());


    }

    @Override
    public ClienteModels getById(long id)
    {
       var entity =  _clientRepository.findById(id).orElse(null);

        if(entity == null){ return null;}

        var result = new ClienteModels();
        result.setFirstName(entity.getFirstName());
        result.setLastName(entity.getSecondName());
        result.setPhoneNumbers(entity.getOtherPhoneNumbers());
        result.setPrincipalPhoneNumber(String.valueOf(entity.getPhoneNumber()));
        result.setId(entity.getId().intValue());

        return result;
    }

    @Override
    public ClienteModels save(ClienteModels model) {
        var entity = new ClientsEntity();
        entity.setFirstName(model.getFirstName());
        entity.setSecondName(model.getLastName());
        entity.setPhoneNumber(Long.parseLong(model.getPrincipalPhoneNumber()));
        entity.setOtherPhoneNumbers(model.getPhoneNumbers());

        _clientRepository.save(entity);
        model.setId(entity.getId().intValue());
        return  model;
    }

    @Override
    public ClienteModels update(ClienteModels model) {
        return null;
    }

    @Override
    public Collection<ClienteModels> updateBulk(List<ClienteModels> models) {
        return null;
    }
}

