package com.labforward.project.web.rest;

import com.labforward.project.domain.BaseEntity;
import com.labforward.project.service.AbstractBaseService;
import com.labforward.project.web.mapper.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
public abstract class AbstractBaseController<E extends AbstractBaseService, T extends BaseMapper, D> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final E service;

    private final T mapper;

    @GetMapping(value = "/findById")
    public D findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional optional = service.findById(id);
        if (optional.isPresent()) {
            return (D) mapper.toDTO(optional.get());
        }
        return null;
    }

    @GetMapping(value = "/findByCode")
    public D findByCode(@RequestParam Long code) throws Exception {
        log.info("Find by code");
        Optional optional = service.findByCode(code);
        if (optional.isPresent()) {
            return (D) mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid D dto) {
        log.info("Persist");
        Object entity = mapper.toEntity(dto);
        service.save(entity);
        return ((BaseEntity) entity).getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }

}
