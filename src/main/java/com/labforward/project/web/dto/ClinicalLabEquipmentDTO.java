package com.labforward.project.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    private MaterialType materialType;

}
