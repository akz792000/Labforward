package com.labforward.project.repository;

import com.labforward.project.domain.AnalyticalInstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticalInstrumentRepository extends JpaRepository<AnalyticalInstrumentEntity, Long>  {
}
