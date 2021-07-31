package com.labforward.project.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.labforward.project.enums.PowerUsageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AnalyticalInstrumentDTO extends InstrumentDTO {

    @JsonProperty
    private PowerUsageType powerUsageType;

}
