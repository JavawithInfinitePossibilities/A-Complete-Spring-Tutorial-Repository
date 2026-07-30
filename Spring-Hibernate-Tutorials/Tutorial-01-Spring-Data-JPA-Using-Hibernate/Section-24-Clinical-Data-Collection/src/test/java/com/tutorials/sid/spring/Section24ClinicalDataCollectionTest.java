package com.tutorials.sid.spring;

import com.tutorials.sid.spring.bean.Car;
import com.tutorials.sid.spring.bean.Person;
import com.tutorials.sid.spring.mockdata.MockDataPrep;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple Section24ClinicalDataCollection.
 */
@SpringBootTest(classes = Section24ClinicalDataCollection.class)
public class Section24ClinicalDataCollectionTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Disabled
    @Test
    void getPeople() {
        try {
            List<Person> people = mockDataPrep.getPeople();
            people.stream().forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void getCars() {
        try {
            List<Car> cars = mockDataPrep.getCars();
            cars.stream().forEach(car -> System.out.println(car.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
