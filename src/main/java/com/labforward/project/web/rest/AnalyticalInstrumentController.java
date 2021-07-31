package com.labforward.project.web.rest;

import com.labforward.project.service.AnalyticalInstrumentService;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import com.labforward.project.web.mapper.AnalyticalInstrumentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RestController
@RequestMapping("/analyticalInstrument")
public class AnalyticalInstrumentController extends AbstractBaseController<AnalyticalInstrumentService, AnalyticalInstrumentMapper, AnalyticalInstrumentDTO> {

    public AnalyticalInstrumentController(AnalyticalInstrumentService service, AnalyticalInstrumentMapper mapper) {
        super(service, mapper);
    }

}
