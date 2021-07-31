package com.labforward.project.web.mapper;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import com.labforward.project.repository.FactoryRepository;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public abstract class AnalyticalInstrumentMapper {

    @Autowired
    private FactoryRepository factoryRepository;

    @AfterMapping
    protected AnalyticalInstrumentEntity attachEntity(@MappingTarget AnalyticalInstrumentEntity entity) {
        entity.setFactories(entity.getFactories().stream().map(item -> factoryRepository.findByCode(item.getCode()).get()).collect(Collectors.toSet()));
        return entity;
    }

    public abstract AnalyticalInstrumentDTO toDTO(AnalyticalInstrumentEntity entity);

    public abstract AnalyticalInstrumentEntity toEntity(AnalyticalInstrumentDTO dto);

}
