package com.jramos.petshopcoreservices.services;

import com.jramos.petshopcoreservices.Models.BodegaModels;
import com.jramos.petshopcoreservices.domain.WareHouseEntity;
import com.jramos.petshopcoreservices.repositories.IWareHouseRepository;
import com.jramos.petshopcoreservices.services.interfaces.IWareHouseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class WareHouseService implements IWareHouseService {

    private final IWareHouseRepository _wareHouseRepository;

    public WareHouseService(IWareHouseRepository wareHouseRepository) {
        _wareHouseRepository = wareHouseRepository;
    }

    @Override
    public Collection<BodegaModels> GetAll()
    {
        return  _wareHouseRepository.findAll().stream().map(x->{
            var dto = new BodegaModels();
            dto.setId(x.getId());
            dto.setNombre(x.getName());
            dto.setDireccion(x.getDirection());
            return  dto;
        }).collect(Collectors.toList());

    }

    @Override
    public BodegaModels GetById(Long id)
    {
        var entity = _wareHouseRepository.findById(id).orElse(null);
        if( entity == null) return  null;

        var result = new BodegaModels();
        result.setId(entity.getId());
        result.setNombre(entity.getName());
        result.setDireccion(entity.getDirection());
        return  result;

    }

    @Override
    public BodegaModels Create(BodegaModels bodega)
    {
        var entity = new WareHouseEntity();
        entity.setName(bodega.getNombre());
        entity.setDirection(bodega.getDireccion());
        _wareHouseRepository.save(entity);
        entity.setId(entity.getId());

        return bodega;
    }

    @Override
    public void Update(BodegaModels bodega) {
        var entity = _wareHouseRepository.findById(bodega.getId()).orElse(null);

        if(entity == null)  throw new RuntimeException("Bodega no encontrada");
        entity.setName(bodega.getNombre());
        entity.setDirection(bodega.getDireccion());
        _wareHouseRepository.save(entity);
    }

    @Override
    public void Delete(Long id)
    {
        _wareHouseRepository.deleteById(id);
    }
}
