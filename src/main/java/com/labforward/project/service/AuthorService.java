package com.labforward.project.service;

import com.labforward.project.domain.AuthorEntity;
import com.labforward.project.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;

    public Optional<AuthorEntity> findById(Long id) {
        return repository.findById(id);
    }

    public AuthorEntity save(AuthorEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
