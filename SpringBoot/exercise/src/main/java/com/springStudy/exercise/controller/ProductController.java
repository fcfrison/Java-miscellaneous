package com.springStudy.exercise.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springStudy.exercise.models.entities.Product;
import com.springStudy.exercise.models.repository.ProductRepository;

@RestController
@RequestMapping(path = "api/")
public class ProductController {
    @Autowired //auto create an ProductRepository instance
    private ProductRepository productRepository;
    @PostMapping(path="new_product")
    public @ResponseBody Product insertProduct(@Valid Product product){//@Valid informs the compiler that 
        /**                                                            // this object will be validated
         * The @ResponseBody annotation signals to the framework exactly what's 
         * the class of what goes in the body of the response to the client.
         */
        productRepository.save(product); //saving the product instance to the data base
        return product;
    }
    @GetMapping(path="product/{id}")
    public Optional<Product> getProductById(@PathVariable(name="id") Integer id){
        return productRepository.findById(id);
    }
    @GetMapping(path="products/{pageNumber}/{numberOfInstancesByPage}")//this method gets data considering the page number;
    Iterable<Product> getByPage(@PathVariable int pageNumber, 
                                @PathVariable int numberOfInstancesByPage){
        if(numberOfInstancesByPage>5){numberOfInstancesByPage=5;}
        PageRequest page = PageRequest.of(pageNumber,numberOfInstancesByPage);//here, we create an object that limits to 2 the number
                                                             // of rows by request
        
                                    
        return productRepository.findAll(page);
    }

    @PutMapping(path = "product/")
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
    @GetMapping(path="product/name/")
    public Iterable<Product> getProductByName(@PathVariable String name){
        return productRepository.findByNameContaining(name);
    }
    @DeleteMapping(path = "product/{id}")
    public void deleteProduct(@PathVariable(name = "id") Integer id){
        productRepository.deleteById(id);
    }
}
