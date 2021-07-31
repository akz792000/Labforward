package com.labforward.project.service;

import com.labforward.project.repository.GenericRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
public class GenericService<R extends GenericRepository<T, ID>, T, ID> {

    private final R repository;

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public Optional<T> findByCode(Long id) {
        return repository.findByCode(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
