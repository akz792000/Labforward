package com.labforward.project.web.rest;

import com.labforward.project.domain. AnalyticalInstrumentEntity;
import com.labforward.project.service. AnalyticalInstrumentService;
import com.labforward.project.web.dto. AnalyticalInstrumentDTO;
import com.labforward.project.web.mapper. AnalyticalInstrumentMapper;
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
@RequestMapping("/ AnalyticalInstrument")
public class AnalyticalInstrumentController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final  AnalyticalInstrumentMapper mapper;

    private final  AnalyticalInstrumentService service;

    @GetMapping(value = "/findById")
    public  AnalyticalInstrumentDTO findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional< AnalyticalInstrumentEntity> optional = service.findById(id);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid  AnalyticalInstrumentDTO dto) {
        log.info("Persist");
         AnalyticalInstrumentEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }

}
