package com.softech.petben.services.springdatajpa;

import com.softech.petben.domain.Product;
import com.softech.petben.repositories.ProductRepository;
import com.softech.petben.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductSDJpaService implements ProductService {

    private final ProductRepository productRepository;

    public ProductSDJpaService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Set<Product> findAll() {
        Set<Product> products = new HashSet<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(Integer integer) {
        return productRepository.findById(integer).orElse(null);
    }

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }
}
