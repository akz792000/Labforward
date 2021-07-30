package com.labforward.project.web.mapper;

import com.labforward.project.domain.CategoryEntity;
import com.labforward.project.web.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDTO toDTO(CategoryEntity entity);

    CategoryEntity toEntity(CategoryDTO dto);

}
