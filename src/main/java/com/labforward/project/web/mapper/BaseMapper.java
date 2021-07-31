package com.labforward.project.web.mapper;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
public interface BaseMapper<E, T> {

    T toDTO(E entity);

    E toEntity(T dto);

}
