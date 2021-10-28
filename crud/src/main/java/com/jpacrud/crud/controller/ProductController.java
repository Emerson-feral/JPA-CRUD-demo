package com.jpacrud.crud.controller;

import java.util.List;

import com.jpacrud.crud.entity.Product;
import com.jpacrud.crud.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    
    @PostMapping("/addProducts")
    public Iterable<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public Iterable<Product> findAllProducts(){
        return service.getProducts();  
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable Integer id){
        return service.getProductById(id);
    }
    
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return service.deleteProduct(id);
    }
    
}
