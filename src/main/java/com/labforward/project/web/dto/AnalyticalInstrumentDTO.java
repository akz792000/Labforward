package com.labforward.project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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

}
