package com.tutorials.sid.spring.services;


import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Service
public class PersonServices {

    @Autowired
    private PersonRepository personRepository;

    public PersonEntity createPersonDetails(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> createPersonDetailsList(List<PersonEntity> person) {
        return (List<PersonEntity>) personRepository.saveAll(person);
    }

    public List<PersonEntity> getAllPersonDetails() {
        return (List<PersonEntity>) personRepository.findAll();
    }

    public PersonEntity getPersonDetailsById(Integer id) {
        return personRepository.findById(id).get();
    }
}
