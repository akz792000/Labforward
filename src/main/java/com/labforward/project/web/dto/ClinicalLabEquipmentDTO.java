package com.labforward.project.web.dto;

import com.labforward.project.enums.MaterialType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@SuperBuilder
@Data
public class ClinicalLabEquipmentDTO extends InstrumentDTO {

    private MaterialType materialType;

}
