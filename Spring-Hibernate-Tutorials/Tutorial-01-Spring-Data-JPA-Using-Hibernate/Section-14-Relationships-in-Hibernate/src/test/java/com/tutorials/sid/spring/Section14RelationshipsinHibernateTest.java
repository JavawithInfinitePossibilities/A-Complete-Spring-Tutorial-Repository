package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.Client;
import com.tutorials.sid.spring.entity.PhoneNumber;
import com.tutorials.sid.spring.repository.IClientRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple Section14RelationshipsinHibernate.
 */
@SpringBootTest(classes = Section14RelationshipsinHibernate.class)
public class Section14RelationshipsinHibernateTest {

    @Autowired
    private IClientRepo iClientRepo;

    @Test
    public void testApp() {

    }
    /*@Disabled*/
    @Test
    public void testCreateClientPhone() {
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("Vodaphone").build();
        PhoneNumber phoneNumber2 = PhoneNumber.builder().number("0987654321").type("Vodaphone").build();
        PhoneNumber phoneNumber3 = PhoneNumber.builder().number("0369852147").type("Vodaphone").build();
        Set<PhoneNumber> phoneNumbers = Set.of(phoneNumber, phoneNumber2, phoneNumber3);
        Client entity = Client.builder().name("siddhant").phoneNumber(phoneNumbers).build();
        phoneNumber.setClient(entity);
        phoneNumber2.setClient(entity);
        phoneNumber3.setClient(entity);
        Client saveClient = iClientRepo.save(entity);
        //assertEquals(entity, saveClient);
    }

    @Disabled
    @Test
    public void testCreateClientPhoneNumber() {
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("Airtel").build();
        PhoneNumber phoneNumber2 = PhoneNumber.builder().number("0987654321").type("Airtel").build();
        PhoneNumber phoneNumber3 = PhoneNumber.builder().number("0369852147").type("Airtel").build();
        Client entity = Client.builder().name("siddhant").build();
        entity.addPhoneNumber(phoneNumber);
        entity.addPhoneNumber(phoneNumber2);
        entity.addPhoneNumber(phoneNumber3);
        Client saveClient = iClientRepo.save(entity);
        assertEquals(entity, saveClient);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSelectClientPhoneNumber() throws InterruptedException {
        Client client = iClientRepo.findById(8).get();
        System.out.println(client);
        Thread.sleep(5000);
        client.setName("kunmun");
        Set<PhoneNumber> phoneNumbers = client.getPhoneNumbers();
        phoneNumbers.stream().forEach(phno -> {
            if (phno.getType() != null) {
                phno.setType("Air-tel");
            }
        });
        Client saveClient = iClientRepo.save(client);
        assertEquals(client, saveClient);
    }
}
