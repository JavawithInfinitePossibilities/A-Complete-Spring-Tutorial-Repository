package com.tutorials.sid.spring;


import com.tutorials.sid.spring.bean.Car;
import com.tutorials.sid.spring.bean.Person;
import com.tutorials.sid.spring.entity.CarEntity;
import com.tutorials.sid.spring.entity.PersonEntity;
import com.tutorials.sid.spring.mockdata.MockDataPrep;
import com.tutorials.sid.spring.services.CarServices;
import com.tutorials.sid.spring.services.PersonServices;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple Section05SimpleCRUDOperation.
 * If we add the resource folder and the application.properties file in the test folder,
 *  then the spring boot will automatically load the test application.properties file.
 * If we add the resource folder and the application.properties file in the test folder
 *  and keep the application.properties empty, then it will through error.
 * So it is mandatory to add all the application.properties details present in the main application.properties
 * file if we add the resource folder in the test.
 */
@SpringBootTest(classes = Section05SimpleCRUDOperation.class)
public class Section05SimpleCRUDOperationTest {

    @Autowired
    private MockDataPrep mockDataPrep;

    @Autowired
    private CarServices carServices;

    @Autowired
    private PersonServices personServices;

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

    /*@Disabled*/
    @Test
    void saveCarsDetails() {
        try {
            List<Car> cars = mockDataPrep.getCars();
            cars.stream().map(carBean -> {
                return CarEntity.builder()
                        /*.id(carBean.getId())*/
                        .price(carBean.getPrice())
                        .year(carBean.getYear())
                        .make(carBean.getMake())
                        .model(carBean.getModel())
                        .color(carBean.getColor())
                        .build();
            }).forEach(car -> {
                CarEntity carDetails = carServices.createCarDetails(car);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void savePersonsDetails() {
        try {
            List<Person> personList = mockDataPrep.getPeople();
            personList.stream().map(personBean -> {
                return PersonEntity.builder()
                        /*.id(personBean.getId())*/
                        .firstName(personBean.getFirstName())
                        .lastName(personBean.getLastName())
                        .age(personBean.getAge())
                        .email(personBean.getEmail())
                        .gender(personBean.getGender())
                        .build();
            }).forEach(person -> {
                PersonEntity personDetails = personServices.createPersonDetails(person);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void savePersonsDetailsList() {
        try {
            List<Person> personList = mockDataPrep.getPeople();
            List<PersonEntity> personEntityList = personList.stream().map(personBean -> {
                return PersonEntity.builder()
                        .id(personBean.getId())
                        .firstName(personBean.getFirstName())
                        .lastName(personBean.getLastName())
                        .age(personBean.getAge())
                        .email(personBean.getEmail())
                        .gender(personBean.getGender())
                        .build();
            }).collect(Collectors.toList());
            List<PersonEntity> personDetailsList = personServices.createPersonDetailsList(personEntityList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void getPersonDetails() {
        List<PersonEntity> allPersonDetails = personServices.getAllPersonDetails();
        allPersonDetails.stream().forEach(person -> {
            System.out.println(person);
        });
    }

    @Test
    void updateCarDetails(){
        CarEntity carEntity=carServices.getCarDetailsById(156);
        carEntity.setColor("Green");
        carServices.createCarDetails(carEntity);
    }
}
