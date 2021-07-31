package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractInstrumentEntity extends BaseEntity {

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

}
