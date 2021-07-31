package com.labforward.project.domain;

import com.labforward.project.enums.InstrumentType;
import com.labforward.project.enums.MaterialType;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Data
@Entity(name = InstrumentType.Name.ClinicalLabEquipment)
@DiscriminatorValue(InstrumentType.Code.ClinicalLabEquipment)
public class ClinicalLabEquipmentEntity extends InstrumentEntity {

    @Enumerated(EnumType.STRING)
    private MaterialType materialType;

    /**
     * declare other dedicated fields
     */

}
