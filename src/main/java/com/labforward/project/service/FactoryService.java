package com.labforward.project.service;

import com.labforward.project.domain.FactoryEntity;
import com.labforward.project.repository.FactoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@Service
public class FactoryService {

    private final FactoryRepository repository;

    public Optional<FactoryEntity> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<FactoryEntity> findByCode(Long id) {
        return repository.findByCode(id);
    }

    public FactoryEntity save(FactoryEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
