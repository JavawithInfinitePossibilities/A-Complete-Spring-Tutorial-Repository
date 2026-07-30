package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.CarEntity;
import com.tutorials.sid.spring.entity.dto.CarDto;
import com.tutorials.sid.spring.services.CarServices;
import com.tutorials.sid.spring.services.PersonServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Unit test for simple Section10PagingAndSortingWithJPQL.
 */
@SpringBootTest(classes = Section10PagingAndSortingWithJPQL.class)
public class Section10PagingAndSortingWithJPQLTest {

    @Autowired
    private CarServices carServices;

    @Test
    public void testApp() {
    }

    @Test
    void getCarDetails() {
        List<CarEntity> allCarDetails = carServices.getCarDetailsByMakeName("Ford");
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }

    @Test
    void getCarDetailsByNameOrderbyYear() {
        PageRequest year = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "year","id"));
        List<CarDto> allCarDetails = carServices.getCarDetailsByMakeNameSortByYear("Ford", year);
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }

}
