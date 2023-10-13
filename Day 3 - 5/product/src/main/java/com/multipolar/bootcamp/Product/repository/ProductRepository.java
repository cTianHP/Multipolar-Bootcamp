package com.multipolar.bootcamp.Product.repository;

import com.multipolar.bootcamp.Product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
