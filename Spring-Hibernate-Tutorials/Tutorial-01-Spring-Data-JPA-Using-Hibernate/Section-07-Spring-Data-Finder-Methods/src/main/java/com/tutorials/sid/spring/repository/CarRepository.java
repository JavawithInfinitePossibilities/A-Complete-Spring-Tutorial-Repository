package com.tutorials.sid.spring.repository;


import com.tutorials.sid.spring.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {
    List<CarEntity> findByMake(String make);
    List<CarEntity> findByColor(String color);
    List<CarEntity> findByModel(String model);
    List<CarEntity> findByYear(Integer year);
    List<CarEntity> findByYearBetween(Integer startYear, Integer endYear);
    List<CarEntity> findByYearGreaterThan(Integer year);
    List<CarEntity> findByYearLessThan(Integer year);
    List<CarEntity> findByYearGreaterThanEqual(Integer year);
    List<CarEntity> findByYearLessThanEqual(Integer year);
}
