package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.entity.dto.PersonDto;
import com.tutorials.sid.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return personRepository.findAllPerson();
    }

    public PersonEntity getPersonDetailsById(Integer id) {
        return personRepository.findById(id).get();
    }

    public List<Object[]> getAllPersonFirstNameAndLastNameDetails() {
        return personRepository.findAllFirstAndLastNameOfPerson();
    }

    public List<PersonDto> getAllPersonFirstNameAndLastNameDetailsByGender(String gender) {
        return personRepository.findAllFirstAndLastNameOfPerson(gender);
    }

    @Transactional
    public void deletePersondetails(Integer id){
        personRepository.deletePersonDetails(id);
    }
}
