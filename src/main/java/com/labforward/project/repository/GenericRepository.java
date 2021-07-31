package com.labforward.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@NoRepositoryBean
public interface GenericRepository<T, ID> extends JpaRepository<T, ID> {

    Optional<T> findByCode(Long code);

}
