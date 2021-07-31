package com.labforward.project.web.mapper;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.repository.FactoryRepository;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public abstract class ClinicalLabEquipmentMapper implements BaseMapper<ClinicalLabEquipmentEntity, ClinicalLabEquipmentDTO> {

    @Autowired
    private FactoryRepository factoryRepository;

    @AfterMapping
    protected ClinicalLabEquipmentEntity attachEntity(ClinicalLabEquipmentDTO dto, @MappingTarget ClinicalLabEquipmentEntity entity) {
        entity.setFactories(dto.getFactories().stream().map(item -> factoryRepository.findByCode(item.getId()).get()).collect(Collectors.toSet()));
        return entity;
    }

}
