package com.labforward.project.repository;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ AnalyticalInstrument Ali Karimizandi
 * @since 2021
 */
@Repository
public interface AnalyticalInstrumentRepository extends JpaRepository<AnalyticalInstrumentEntity, Long> {

}
