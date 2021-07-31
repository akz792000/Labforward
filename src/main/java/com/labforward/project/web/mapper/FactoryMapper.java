package com.labforward.project.web.mapper;

import com.labforward.project.domain.FactoryEntity;
import com.labforward.project.web.dto.FactoryDTO;
import org.mapstruct.Mapper;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public interface FactoryMapper extends BaseMapper<FactoryEntity, FactoryDTO> {

}
