package com.labforward.project.service;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.repository.ClinicalLabEquipmentRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Service
public class ClinicalLabEquipmentService extends AbstractBaseService<ClinicalLabEquipmentRepository, ClinicalLabEquipmentEntity, Long> {

    public ClinicalLabEquipmentService(ClinicalLabEquipmentRepository repository) {
        super(repository);
    }

}
