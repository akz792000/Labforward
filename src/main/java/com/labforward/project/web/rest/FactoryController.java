package com.labforward.project.web.rest;

import com.labforward.project.domain.FactoryEntity;
import com.labforward.project.service.FactoryService;
import com.labforward.project.web.dto.FactoryDTO;
import com.labforward.project.web.mapper.FactoryMapper;
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
@RestController
@RequestMapping("/factory")
public class FactoryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FactoryMapper mapper;

    private final FactoryService service;

    @GetMapping(value = "/findById")
    public FactoryDTO findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional<FactoryEntity> optional = service.findById(id);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @GetMapping(value = "/findByCode")
    public FactoryDTO findByCode(@RequestParam Long code) throws Exception {
        log.info("Find by code");
        Optional<FactoryEntity> optional = service.findByCode(code);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid FactoryDTO dto) {
        log.info("Persist");
        FactoryEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }

}
