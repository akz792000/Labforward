package com.labforward.project.web.mapper;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import org.mapstruct.Mapper;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public interface AnalyticalInstrumentMapper {

    AnalyticalInstrumentDTO toDTO(AnalyticalInstrumentEntity entity);

    AnalyticalInstrumentEntity toEntity(AnalyticalInstrumentDTO dto);

}
