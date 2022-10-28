package com.springStudy.exercise.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springStudy.exercise.models.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    /**
     * The CrudRepository interface requeries the identification of the class 
     * whose repository it encapsulates and the class of the id.
     */
    public Iterable<Product> findByNameContaining(String name);
    
}
