package com.jramos.petshopcoreservices.services.interfaces;

import com.jramos.petshopcoreservices.Models.ProductosModels;

import java.util.Collection;
import java.util.List;

public interface IProductService {

    Collection<ProductosModels> getAll();

    ProductosModels getById(Long id);

    ProductosModels getByCategory(Long id);

    ProductosModels update(ProductosModels producto);

    Collection<ProductosModels> updateBulk(List<ProductosModels> productos);

    ProductosModels save(ProductosModels producto);
}
