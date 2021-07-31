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
    private String title;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "instrument_factory",
            joinColumns = {@JoinColumn(name = "instrument_id")},
            inverseJoinColumns = {@JoinColumn(name = "factory_id")}
    )
    private Set<FactoryEntity> factories = new HashSet<>();

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(length = 1000)
    private String description;

}
