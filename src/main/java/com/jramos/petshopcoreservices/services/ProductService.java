package com.jramos.petshopcoreservices.services;


import com.jramos.petshopcoreservices.PetShopCoreServicesApplication;
import com.jramos.petshopcoreservices.domain.ProductEntity;
import com.jramos.petshopcoreservices.repositories.IProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final IProductsRepository _productosRepo;

    @Autowired
    public ProductService(IProductsRepository productsRepository) {
        _productosRepo = productsRepository;
    }
     public String[] ListOfServices()
     {
         List<ProductEntity> productos = _productosRepo.findAll();
         log.info("Size productos: " +productos.size());
         return new String[]{"Test1", "Test2"};
     }

}
