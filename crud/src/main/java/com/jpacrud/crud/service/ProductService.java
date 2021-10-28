package com.jpacrud.crud.service;

import java.util.List;

import com.jpacrud.crud.entity.Product;
import com.jpacrud.crud.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    //POST
    @Autowired
    private IProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    
    public Iterable<Product> saveProducts( List<Product> products){
        return repository.saveAll(products);
    }

    //GET
    public Iterable<Product> getProducts(){
        return repository.findAll();
    }
    
    public Product getProductById( Integer id){
        return repository.findById(id).orElse(null);
    }
    
    public Product getProductByName( String name){
        return repository.findByName(name);
    }

    //DELETE
    public String deleteProduct(Integer id){
        repository.deleteById(id);
        return "Product removed " + id;
    }

    //UPDATE
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }



}
