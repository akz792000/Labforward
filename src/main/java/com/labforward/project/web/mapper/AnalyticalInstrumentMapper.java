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
public abstract class AnalyticalInstrumentMapper implements BaseMapper<AnalyticalInstrumentEntity, AnalyticalInstrumentDTO> {

    @Autowired
    private FactoryRepository factoryRepository;

    @AfterMapping
    protected AnalyticalInstrumentEntity attachEntity(AnalyticalInstrumentDTO dto, @MappingTarget AnalyticalInstrumentEntity entity) {
        entity.setFactories(dto.getFactories().stream().map(item -> factoryRepository.findByCode(item.getId()).get()).collect(Collectors.toSet()));
        return entity;
    }

}
