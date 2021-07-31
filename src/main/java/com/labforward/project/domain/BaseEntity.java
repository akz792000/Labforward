package com.labforward.project.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name = "version", precision = 12)
    private Long version;

}
