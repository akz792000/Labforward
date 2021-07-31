package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "analytical_instrument")
public class AnalyticalInstrumentEntity extends AbstractInstrumentEntity {

}
