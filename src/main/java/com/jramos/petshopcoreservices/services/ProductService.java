package com.jramos.petshopcoreservices.services;


import com.jramos.petshopcoreservices.Models.ProductosModels;
import com.jramos.petshopcoreservices.repositories.IProductsRepository;
import com.jramos.petshopcoreservices.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService  implements IProductService {


    private final IProductsRepository _productosRepo;


    public ProductService(IProductsRepository productsRepository) {
        _productosRepo = productsRepository;
    }


    @Override
    public Collection<ProductosModels> getAll() {

        return _productosRepo.findAll().stream().map(x->{
            ProductosModels model = new ProductosModels();
            model.setId(x.getId().intValue());
            model.setDescripcion(x.getDescription());
            model.setNombre(x.getName());
            model.setFechaCreado(x.getCreated());

            return model;
        }).collect(Collectors.toList());

    }

    @Override
    public ProductosModels getById(Long id) {
        return null;
    }

    @Override
    public ProductosModels getByCategory(Long id) {
        return null;
    }

    @Override
    public ProductosModels update(ProductosModels producto) {
        return null;
    }

    @Override
    public Collection<ProductosModels> updateBulk(List<ProductosModels> productos) {
        return null;
    }

    @Override
    public ProductosModels save(ProductosModels producto) {
        return null;
    }
}
