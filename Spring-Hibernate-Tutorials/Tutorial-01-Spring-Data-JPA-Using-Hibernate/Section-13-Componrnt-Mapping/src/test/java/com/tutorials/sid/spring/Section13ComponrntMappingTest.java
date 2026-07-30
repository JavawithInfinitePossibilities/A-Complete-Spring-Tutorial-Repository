package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Address;
import com.tutorials.sid.spring.entity.Employee;
import com.tutorials.sid.spring.repositories.IEmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple Section13ComponrntMapping.
 */
@SpringBootTest(classes = Section13ComponrntMapping.class)
public class Section13ComponrntMappingTest {

    @Autowired
    private IEmployeeRepo iEmployeeRepo;

    @Test
    public void testApp() {
    }

    @Test
    public void testCreateemployee() {
        Address address = Address.builder().streetaddress("101").city("Bangalore").state("Karnatak").zipcode("560037")
                .country("India").build();
        Employee employee = Employee.builder().firstName("Sid").lastName("Sahu").address(address).build();
        Employee saveEmployee = iEmployeeRepo.save(employee);
        System.out.println(saveEmployee);
    }
}
