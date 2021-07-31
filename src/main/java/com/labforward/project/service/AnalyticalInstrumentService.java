package com.labforward.project.service;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import com.labforward.project.repository.AnalyticalInstrumentRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Service
public class AnalyticalInstrumentService extends AbstractBaseService<AnalyticalInstrumentRepository, AnalyticalInstrumentEntity, Long> {

    public AnalyticalInstrumentService(AnalyticalInstrumentRepository repository) {
        super(repository);
    }

}
