package com.labforward.project.web.rest;

import com.labforward.project.domain.CategoryEntity;
import com.labforward.project.service.CategoryService;
import com.labforward.project.web.dto.CategoryDTO;
import com.labforward.project.web.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CategoryMapper mapper;

    private final CategoryService service;

    @PostMapping(value = "/save")
    public Long persist(final @RequestBody @Valid CategoryDTO dto) {
        log.info("Saving widget details in the database.");
        CategoryEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

}
