package com.labforward.project.repository;

import com.labforward.project.domain.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

}
