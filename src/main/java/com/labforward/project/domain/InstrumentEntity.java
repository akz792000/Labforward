package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Data
@Entity(name = "instrument")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "instrument_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class InstrumentEntity extends BaseEntity {

    @Column
    protected String title;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "instrument_author",
            joinColumns = {@JoinColumn(name = "instrument_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    Set<AuthorEntity> authors = new HashSet<>();

    @Column
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    @Column(length = 1000)
    private String description;

}
