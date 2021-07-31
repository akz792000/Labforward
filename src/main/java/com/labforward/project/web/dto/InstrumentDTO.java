package com.labforward.project.web.dto;

import com.labforward.project.domain.FactoryEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@SuperBuilder
@Data
public class InstrumentDTO {

    private Long id;

    private String title;

    private Set<FactoryEntity> factories = new HashSet<>();

    private Date date;

    private String description;

}
