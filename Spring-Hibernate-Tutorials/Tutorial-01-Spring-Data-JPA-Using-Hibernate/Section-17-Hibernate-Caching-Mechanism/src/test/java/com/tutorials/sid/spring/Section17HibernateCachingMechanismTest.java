package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Driver;
import com.tutorials.sid.spring.entity.License;
import com.tutorials.sid.spring.repository.ILicenseRepo;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple Section17HibernateCachingMechanism.
 */
@SpringBootTest(classes = Section17HibernateCachingMechanism.class)
public class Section17HibernateCachingMechanismTest {

    @Autowired
    private ILicenseRepo iLicenseRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testApp() {
    }

    @Disabled
    @Test
    public void testOneToOneDriverlicense() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        License license = License.builder().type("Bike").validFrom(format.parse(LocalDate.of(2010, 01, 01).toString()))
                .validTo(format.parse(LocalDate.now().toString())).build();
        Driver driver = Driver.builder().firstName("Sid").lastName("Sahu").age(33).build();
        license.setDriver(driver);
        driver.setLicense(license);
        License LicenseSave = iLicenseRepo.save(license);
        assertEquals(license, LicenseSave);
    }

    @Test
    @Transactional
    public void testSelectOneToOneDriverlicense() {
        Session session = entityManager.unwrap(Session.class);
        License license = iLicenseRepo.findById(2).orElseThrow(() -> new RuntimeException("License not found"));
        iLicenseRepo.findById(2);
        iLicenseRepo.findById(2);
        session.evict(license);
        iLicenseRepo.findById(2);
    }
}
