package com.labforward.project.web.rest;

import com.labforward.project.domain.ClinicalLabEquipmentEntity;
import com.labforward.project.service.ClinicalLabEquipmentService;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
import com.labforward.project.web.mapper.ClinicalLabEquipmentMapper;
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
@RequestMapping("/clinicalLabEquipment")
public class ClinicalLabEquipmentController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ClinicalLabEquipmentMapper mapper;

    private final ClinicalLabEquipmentService service;

    @GetMapping(value = "/findById")
    public ClinicalLabEquipmentDTO findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional<ClinicalLabEquipmentEntity> optional = service.findById(id);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid ClinicalLabEquipmentDTO dto) {
        log.info("Persist");
        ClinicalLabEquipmentEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }

}
