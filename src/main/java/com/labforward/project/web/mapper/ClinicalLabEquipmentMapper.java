package com.labforward.project.web.mapper;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.repository.ClinicalLabEquipmentRepository;
import com.labforward.project.repository.FactoryRepository;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public abstract class ClinicalLabEquipmentMapper implements BaseMapper<ClinicalLabEquipmentEntity, ClinicalLabEquipmentDTO> {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private ClinicalLabEquipmentRepository clinicalLabEquipmentRepository;

    @ObjectFactory
    public ClinicalLabEquipmentEntity createEntity(ClinicalLabEquipmentDTO dto) {
        if (dto == null || dto.getId() == null) return new ClinicalLabEquipmentEntity();
        Optional<ClinicalLabEquipmentEntity> optional = clinicalLabEquipmentRepository.findById(dto.getId());
        if (optional.isPresent()) return optional.get();
        throw new UnsupportedOperationException();
    }

    @AfterMapping
    protected void attachEntity(ClinicalLabEquipmentDTO dto, @MappingTarget ClinicalLabEquipmentEntity entity) {
        entity.setFactories(dto.getFactories().stream().map(item -> factoryRepository.findById(item.getId()).get()).collect(Collectors.toSet()));
    }

}
