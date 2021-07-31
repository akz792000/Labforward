package com.labforward.project.web.dto;

import com.labforward.project.enums.PowerUsageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnalyticalInstrumentDTO {

    private Long id;

    private String title;

    private PowerUsageType powerUsageType;

}
