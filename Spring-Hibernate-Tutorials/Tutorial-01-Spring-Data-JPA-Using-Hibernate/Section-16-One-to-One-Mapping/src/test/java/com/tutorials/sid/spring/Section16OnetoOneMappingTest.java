package com.tutorials.sid.spring;

import com.tutorials.sid.spring.entity.Driver;
import com.tutorials.sid.spring.entity.License;
import com.tutorials.sid.spring.repository.ILicenseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple Section16OnetoOneMapping.
 */
@SpringBootTest(classes = Section16OnetoOneMapping.class)
public class Section16OnetoOneMappingTest {
    @Autowired
    private ILicenseRepo iLicenseRepo;

    @Test
    public void testApp() {
    }

    @Test
    public void testOneToOneDriverlicense() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        License license = License.builder().type("Bike")
                .validFrom(format.parse(LocalDate.of(2010, 01, 01).toString()))
                .validTo(format.parse(LocalDate.now().toString()))
                .build();
        Driver driver = Driver.builder().firstName("Sid").lastName("Sahu").age(33).build();
        license.setDriver(driver);
        driver.setLicense(license);
        License LicenseSave = iLicenseRepo.save(license);
        assertEquals(license, LicenseSave);
    }

    @Test
    public void testOneToOneDriverlicenseSelect() {
        License license = iLicenseRepo.findById(2).orElseThrow(() -> new RuntimeException("License not found"));
        System.out.println(license);
    }
}
