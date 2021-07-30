package com.labforward.project.web.dto;

import lombok.Data;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Data
public class InstrumentDTO {

    private Long id;

    private String name;

    private CategoryDTO category;

}
