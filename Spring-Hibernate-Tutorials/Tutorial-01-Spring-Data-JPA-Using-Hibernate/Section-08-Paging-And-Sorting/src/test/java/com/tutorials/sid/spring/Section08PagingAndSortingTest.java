package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.CarEntity;
import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.services.CarServices;
import com.tutorials.sid.spring.services.PersonServices;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple Section08PagingAndSorting.
 */
@SpringBootTest(classes = Section08PagingAndSorting.class)
public class Section08PagingAndSortingTest {

    @Autowired
    private CarServices carServices;

    @Autowired
    private PersonServices personServices;

    @Test
    public void testApp() {
    }

    /*
    This is for Section-08-Paging-And-Sorting
     */

    @Disabled
    @Test
    void getCarDetailsByPaging() {
        List<CarEntity> allCarDetails = carServices
                .getCarDetailsPagingAndSorting(15, 10, "id");
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }

    @Disabled
    @Test
    void getCarDetails() {
        List<CarEntity> allCarDetails = carServices.getCarDetailsByMakeName("Ford");
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }

    @Disabled
    @Test
    void getCarDetailsPageable() {
        PageRequest pageRequest = PageRequest.of(8, 10, Sort.by(Sort.Direction.ASC, "id"));
        List<CarEntity> allCarDetails = carServices.getCarDetailsByMakeNamePageable("Ford", pageRequest);
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }

    @Test
    void getPersonDetailsPageableByMultipleSortedColumn() {
        Sort columnDetails = Sort.by(Sort.Order.asc("age"), Sort.Order.desc("id"));
        List<PersonEntity> allPersonDetailsByPagingAndSorting = personServices
                .getAllPersonDetailsByPagingAndSorting(14, 10, columnDetails);
        allPersonDetailsByPagingAndSorting.stream().forEach(System.out::println);
    }
}
