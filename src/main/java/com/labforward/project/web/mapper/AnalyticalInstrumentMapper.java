package com.labforward.project.web.mapper;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import com.labforward.project.repository.AnalyticalInstrumentRepository;
import com.labforward.project.repository.FactoryRepository;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public abstract class AnalyticalInstrumentMapper implements BaseMapper<AnalyticalInstrumentEntity, AnalyticalInstrumentDTO> {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private AnalyticalInstrumentRepository analyticalInstrumentRepository;

    @ObjectFactory
    public AnalyticalInstrumentEntity createEntity(AnalyticalInstrumentDTO dto) {
        if (dto == null || dto.getId() == null) return new AnalyticalInstrumentEntity();
        Optional<AnalyticalInstrumentEntity> optional = analyticalInstrumentRepository.findById(dto.getId());
        if (optional.isPresent()) return optional.get();
        throw new UnsupportedOperationException();
    }

    @AfterMapping
    protected void attachEntity(AnalyticalInstrumentDTO dto, @MappingTarget AnalyticalInstrumentEntity entity) {
        entity.setFactories(dto.getFactories().stream().map(item -> factoryRepository.findById(item.getId()).get()).collect(Collectors.toSet()));
    }

}
