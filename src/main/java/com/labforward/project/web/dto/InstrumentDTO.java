package com.labforward.project.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class InstrumentDTO {

    @JsonProperty
    private Long code;

    @JsonProperty
    private String title;

    @JsonProperty
    private Set<FactoryDTO> factories = new HashSet<>();

    @JsonProperty
    private Date date;

    @JsonProperty
    private String description;

}
