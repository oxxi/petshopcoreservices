package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.BodegaModels;

import java.util.Collection;

public interface IWareHouseService {


    Collection<BodegaModels> GetAll();
    BodegaModels GetById(Long id);
    BodegaModels Create(BodegaModels bodega);
    void Update(BodegaModels bodega);
    void Delete(Long id);

}
