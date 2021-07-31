package com.labforward.project.service;

import com.labforward.project.domain.CategoryEntity;
import com.labforward.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository repository;

    public Optional<CategoryEntity> findById(Long id) {
        return repository.findById(id);
    }

    public CategoryEntity save(CategoryEntity stock) {
        return repository.save(stock);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
