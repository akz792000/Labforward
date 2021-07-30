package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Data
@Entity(name = "instrument")
public class InstrumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

}
