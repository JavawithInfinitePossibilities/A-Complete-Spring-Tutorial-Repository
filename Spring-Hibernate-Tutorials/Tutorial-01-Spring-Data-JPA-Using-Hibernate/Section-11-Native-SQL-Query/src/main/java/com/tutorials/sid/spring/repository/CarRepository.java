package com.tutorials.sid.spring.repository;


import com.tutorials.sid.spring.entity.CarEntity;
import com.tutorials.sid.spring.entity.dto.CarDto;
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

    /*to map the select field list to an object create a interface with the getter method without properties.
    this will map the selected field list to the object
    */
    @Query(value = "Select id, color, make_description as make, model, price, year from Car where make_description=:maker", nativeQuery = true)
    public List<CarDto> getAllCarsDetails(@Param("maker") String maker);
}
