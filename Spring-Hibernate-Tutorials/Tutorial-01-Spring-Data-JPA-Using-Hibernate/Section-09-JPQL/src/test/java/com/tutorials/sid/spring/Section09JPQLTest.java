package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.entity.dto.PersonDto;
import com.tutorials.sid.spring.services.CarServices;
import com.tutorials.sid.spring.services.PersonServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Unit test for simple Section09JPQL.
 */
@SpringBootTest(classes = Section09JPQL.class)
public class Section09JPQLTest {

    @Autowired
    private CarServices carServices;

    @Autowired
    private PersonServices personServices;

    @Test
    public void testApp() {
    }

    /*
     *Section-09-JPQL test
     * */
    @Test
    void getPersonDetails() {
        List<PersonEntity> allPersonDetails = personServices.getAllPersonDetails();
        allPersonDetails.stream().forEach(person -> {
            System.out.println(person);
        });
    }

    @Test
    void getPersonFirstAndLastNameDetails() {
        List<Object[]> allPersonDetails = personServices.getAllPersonFirstNameAndLastNameDetails();
        allPersonDetails.stream().forEach(person -> {
            System.out.println(person[0]+"  "+person[1]);
        });
    }

    @Test
    void getPersonFirstAndLastNameDetailsByGender() {
        List<PersonDto> allPersonDetails = personServices.getAllPersonFirstNameAndLastNameDetailsByGender("Male");
        allPersonDetails.stream().forEach(person -> {
            System.out.println(person);
        });
    }


    @Rollback(value = false)
    @Test
    void deletePersonDetails() {
        personServices.deletePersondetails(3015);
    }
}
