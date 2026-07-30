package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.entity.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    @Query("from PersonEntity ")
    public List<PersonEntity> findAllPerson();

    @Query("Select pr.firstName,pr.lastName from PersonEntity pr")
    public List<Object[]> findAllFirstAndLastNameOfPerson();

    @Query("Select new com.tutorials.sid.spring.entity.dto.PersonDto(pr.firstName,pr.lastName) from PersonEntity pr where pr.gender=:gender")
    public List<PersonDto> findAllFirstAndLastNameOfPerson(@Param("gender") String gender);

    @Modifying
    @Query("Delete from PersonEntity pr where pr.id=:id")
    public void deletePersonDetails(@Param("id")Integer id);
}
