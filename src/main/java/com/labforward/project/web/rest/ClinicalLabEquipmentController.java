package com.labforward.project.web.rest;

import com.labforward.project.service.ClinicalLabEquipmentService;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
import com.labforward.project.web.mapper.ClinicalLabEquipmentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RestController
@RequestMapping("/clinicalLabEquipment")
public class ClinicalLabEquipmentController extends AbstractBaseController<ClinicalLabEquipmentService, ClinicalLabEquipmentMapper, ClinicalLabEquipmentDTO> {

    public ClinicalLabEquipmentController(ClinicalLabEquipmentService service, ClinicalLabEquipmentMapper mapper) {
        super(service, mapper);
    }

}
