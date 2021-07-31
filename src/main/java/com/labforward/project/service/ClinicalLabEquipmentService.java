package com.labforward.project.service;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.repository.ClinicalLabEquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@Service
public class ClinicalLabEquipmentService {

    private final ClinicalLabEquipmentRepository repository;

    public Optional<ClinicalLabEquipmentEntity> findById(Long id) {
        return repository.findById(id);
    }

    public ClinicalLabEquipmentEntity save(ClinicalLabEquipmentEntity entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
