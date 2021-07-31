package com.labforward.project.repository;

import com.labforward.project.domain.FactoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@Repository
public interface FactoryRepository extends JpaRepository<FactoryEntity, Long> {

}
