package com.labforward.project.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class FactoryDTO extends BaseDTO {

    @JsonProperty
    private String name;

}
