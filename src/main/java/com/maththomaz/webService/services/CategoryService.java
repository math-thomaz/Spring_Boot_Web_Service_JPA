package com.maththomaz.webService.services;

import com.maththomaz.webService.entities.Category;
import com.maththomaz.webService.entities.User;
import com.maththomaz.webService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj =  categoryRepository.findById(id);
        return obj.get();
    }
}
