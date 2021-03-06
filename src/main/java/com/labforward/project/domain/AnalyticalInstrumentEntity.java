package com.labforward.project.domain;

import com.labforward.project.enums.InstrumentType;
import com.labforward.project.enums.PowerUsageType;
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
@Entity(name = InstrumentType.Name.AnalyticalInstrument)
@DiscriminatorValue(InstrumentType.Code.AnalyticalInstrument)
public class AnalyticalInstrumentEntity extends InstrumentEntity {

    @Enumerated(EnumType.STRING)
    private PowerUsageType powerUsageType;

    /**
     * declare other dedicated fields
     */

}
