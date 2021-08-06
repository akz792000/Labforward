package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Data
@Entity(name = "factory")
public class FactoryEntity extends AuditEntity {

    @Column(name = "name")
    private String name;

}
