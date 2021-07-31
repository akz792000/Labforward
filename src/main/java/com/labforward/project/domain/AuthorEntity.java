package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Data
@Entity(name = "author")
public class AuthorEntity extends BaseEntity {

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    String lastName;

}
