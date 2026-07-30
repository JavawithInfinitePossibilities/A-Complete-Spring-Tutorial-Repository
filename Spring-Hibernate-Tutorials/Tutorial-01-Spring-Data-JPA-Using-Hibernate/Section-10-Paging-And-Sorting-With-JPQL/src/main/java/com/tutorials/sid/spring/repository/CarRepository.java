package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.dto.CarDto;
import com.tutorials.sid.spring.entity.CarEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>, PagingAndSortingRepository<CarEntity, Integer> {
    List<CarEntity> findByMake(String make);

    @Query("select new com.tutorials.sid.spring.entity.dto.CarDto(ce.id,ce.make,ce.model,ce.color) from CarEntity ce where ce.make=:maker")
    public List<CarDto> getAllCarDetailsByNameSortbyYear(@Param("maker") String make, Pageable pageable);
}
