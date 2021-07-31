package com.labforward.project.web.rest;

import com.labforward.project.domain.AuthorEntity;
import com.labforward.project.service.AuthorService;
import com.labforward.project.web.dto.AuthorDTO;
import com.labforward.project.web.mapper.AuthorMapper;
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
@RequestMapping("/author")
public class AuthorController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AuthorMapper mapper;

    private final AuthorService service;

    @GetMapping(value = "/findById")
    public AuthorDTO findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional<AuthorEntity> optional = service.findById(id);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid AuthorDTO dto) {
        log.info("Persist");
        AuthorEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }

}
