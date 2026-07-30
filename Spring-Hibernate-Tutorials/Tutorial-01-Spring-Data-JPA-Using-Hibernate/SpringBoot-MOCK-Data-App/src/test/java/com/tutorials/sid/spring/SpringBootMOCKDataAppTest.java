package com.tutorials.sid.spring;

import com.tutorials.sid.spring.bean.Car;
import com.tutorials.sid.spring.bean.Person;
import com.tutorials.sid.spring.mockdata.MockDataPrep;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple SpringBootMOCKDataApp.
 */
@SpringBootTest(classes = SpringBootMOCKDataApp.class)
public class SpringBootMOCKDataAppTest {

    @Autowired
    private MockDataPrep mockDataPrep;

    @Test
    public void testApp() {
        System.out.println("Hello World!");
    }

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
