package com.tutorials.sid.spring;


import com.tutorials.sid.spring.model.componentMapping.CustomerId;
import com.tutorials.sid.spring.model.db.Customer;
import com.tutorials.sid.spring.repositories.ICustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple Section23CompositePrimaryKeys.
 */
@SpringBootTest(classes = Section23CompositePrimaryKeys.class)
public class Section23CompositePrimaryKeysTest {

    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Test
    public void testApp() {
    }

    @Test
    public void testSaveCustomer() {
        CustomerId id = CustomerId.builder().id((int) (Math.random()*10)).email("abc@gmail.com").build();
        Customer customer = Customer.builder().customerId(id).name("ZYX").build();
        Customer saveCustomer = iCustomerRepo.save(customer);
    }
}
