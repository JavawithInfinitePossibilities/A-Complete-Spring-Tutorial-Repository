package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.CarEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer>, PagingAndSortingRepository<CarEntity, Integer> {
    List<CarEntity> findByMake(String make, Pageable pageable);

    List<CarEntity> findByMake(String make);
}
