package com.labforward.project.web.mapper;

import com.labforward.project.domain.AuthorEntity;
import com.labforward.project.web.dto.AuthorDTO;
import org.mapstruct.Mapper;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Mapper
public interface AuthorMapper {

    AuthorDTO toDTO(AuthorEntity entity);

    AuthorEntity toEntity(AuthorDTO dto);

}
