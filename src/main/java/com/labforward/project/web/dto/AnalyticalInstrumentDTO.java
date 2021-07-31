package com.labforward.project.web.dto;

import com.labforward.project.enums.PowerUsageType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@SuperBuilder
@Data
public class AnalyticalInstrumentDTO extends InstrumentDTO {

    private PowerUsageType powerUsageType;


}
