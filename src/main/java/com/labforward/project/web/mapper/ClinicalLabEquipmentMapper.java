package com.labforward.project.web.mapper;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
import org.mapstruct.Mapper;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public interface ClinicalLabEquipmentMapper {

    ClinicalLabEquipmentDTO toDTO(ClinicalLabEquipmentEntity entity);

    ClinicalLabEquipmentEntity toEntity(ClinicalLabEquipmentDTO dto);

}
