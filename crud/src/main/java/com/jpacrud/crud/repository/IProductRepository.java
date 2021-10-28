package com.jpacrud.crud.repository;

import com.jpacrud.crud.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Integer> {

    Product findByName(String name);
    
}
