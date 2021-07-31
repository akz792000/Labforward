package com.labforward.project.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Version
    @Column(name = "version", precision = 12)
    private Long version;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

}
