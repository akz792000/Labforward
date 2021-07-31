package com.labforward.project.service;

import com.labforward.project.domain.FactoryEntity;
import com.labforward.project.repository.FactoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author Ali Karimizandi
 * @since 2021
 */

@Service
public class FactoryService extends GenericService<FactoryRepository, FactoryEntity, Long> {

    public FactoryService(FactoryRepository repository) {
        super(repository);
    }

}
