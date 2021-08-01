package com.labforward.project.web.mapper;

import com.labforward.project.domain.FactoryEntity;
import com.labforward.project.repository.FactoryRepository;
import com.labforward.project.web.dto.FactoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public abstract class FactoryMapper implements BaseMapper<FactoryEntity, FactoryDTO> {

    @Autowired
    private FactoryRepository factoryRepository;

    @ObjectFactory
    public FactoryEntity createEntity(FactoryDTO dto) {
        if (dto == null || dto.getId() == null) return new FactoryEntity();
        Optional<FactoryEntity> optional = factoryRepository.findById(dto.getId());
        if (optional.isPresent()) return optional.get();
        throw new UnsupportedOperationException();
    }

}
