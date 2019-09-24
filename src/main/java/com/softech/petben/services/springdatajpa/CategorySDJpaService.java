package com.softech.petben.services.springdatajpa;

import com.softech.petben.domain.Category;
import com.softech.petben.repositories.CategoryRepository;
import com.softech.petben.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategorySDJpaService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategorySDJpaService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public List<Category> search(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryRepository.findById(integer).orElse(null);
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        categoryRepository.deleteById(integer);
    }
}
