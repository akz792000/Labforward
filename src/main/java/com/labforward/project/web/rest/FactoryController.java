package com.labforward.project.web.rest;

import com.labforward.project.service.FactoryService;
import com.labforward.project.web.dto.FactoryDTO;
import com.labforward.project.web.mapper.FactoryMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RestController
@RequestMapping("/factory")
public class FactoryController extends AbstractBaseController<FactoryService, FactoryMapper, FactoryDTO> {

    public FactoryController(FactoryService service, FactoryMapper mapper) {
        super(service, mapper);
    }

}
