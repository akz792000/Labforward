package com.labforward.project.service;

import com.labforward.project.domain.BaseEntity;
import com.labforward.project.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
public abstract class AbstractBaseService<R extends BaseRepository<T, ID>, T extends BaseEntity, ID> {

    private final R repository;

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public Optional<T> findByCode(Long id) {
        return repository.findByCode(id);
    }

    public T save(T entity) {
        if (entity == null) return null;
        entity = repository.save(entity);
        return entity;
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
