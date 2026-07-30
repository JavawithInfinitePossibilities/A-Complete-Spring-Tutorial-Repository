package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.dto.CarDto;
import com.tutorials.sid.spring.services.CarServices;
import com.tutorials.sid.spring.services.PersonServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Unit test for simple Section11NativeSQLQuery.
 */
@SpringBootTest(classes = Section11NativeSQLQuery.class)
public class Section11NativeSQLQueryTest {

    @Autowired
    private CarServices carServices;

    @Test
    public void testApp() {
        System.out.println("Hello World!");
    }

    @Test
    void getCarDetailsByMakerName() {
        List<CarDto> allCarDetails = carServices.getAllCarDetailsByMakerName("Ford");
        allCarDetails.stream().forEach(carDto -> {
            System.out.println(carDto.getId() + " " + carDto.getMake() + " " + carDto.getColor() + " "
                    + carDto.getModel() + " " + carDto.getPrice() + " " + carDto.getYear());
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }
}
