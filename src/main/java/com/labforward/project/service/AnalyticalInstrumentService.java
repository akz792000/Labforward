package com.labforward.project.service;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import com.labforward.project.repository.AnalyticalInstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@Service
public class AnalyticalInstrumentService {

    private final AnalyticalInstrumentRepository repository;

    public Optional<AnalyticalInstrumentEntity> findById(Long id) {
        return repository.findById(id);
    }

    public AnalyticalInstrumentEntity save(AnalyticalInstrumentEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
