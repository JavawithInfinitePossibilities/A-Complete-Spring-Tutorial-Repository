package com.tutorials.sid.spring;


import com.tutorials.sid.spring.model.entity.*;
import com.tutorials.sid.spring.repositories.IPaymentRepo;
import com.tutorials.sid.spring.repositories.IPersonRepo;
import com.tutorials.sid.spring.repositories.IVehicleRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple Section12InheritanceMapping.
 */
@SpringBootTest(classes = Section12InheritanceMapping.class)
public class Section12InheritanceMappingTest {

    @Autowired
    private IPaymentRepo iPaymentRepo;

    @Autowired
    private IPersonRepo iPersonRepo;

    @Autowired
    private IVehicleRepo iVehicleRepo;

    @Test
    public void testApp() {
    }

    @Disabled
    @Test
    public void testCreatePayment() {
        CreditCard creditCard = iPaymentRepo.save(CreditCard.builder().amount(1500)
                .creditCardNumber("123567890123").build());
        Check check = iPaymentRepo.save(Check.builder().amount(2000).checkNumber("12345690321").build());
        System.out.println(creditCard);
        System.out.println(check);
    }

    @Disabled
    @Test
    public void testCreatePerson() {
        Contractor contractor = iPersonRepo.save(Contractor.builder().firstName("sidhant").lastName("sahu")
                .employeeNumber("123567890").managerNumber("098745631").build());
        Manager manager = iPersonRepo
                .save(Manager.builder().firstName("Sarang").lastName("Joshi").employeeNumber("098745631").build());
        System.out.println(contractor);
        System.out.println(manager);
    }

    @Test
    public void testCreateVehicle() {
        Vehicle4Wheeler vehicle4Wheeler = iVehicleRepo.save(Vehicle4Wheeler.builder().vahicleNumber("KA-53 2422")
                .vahicleCategory("Car").vehicleType("SUV").vehileBrand("AUDI").build());
        Vehicle2Wheeler vehicle2Wheeler = iVehicleRepo.save(Vehicle2Wheeler.builder().vahicleNumber("KA-53 2224")
                .vehicleType("Byke").vahicleCategory("Racing").vehileBrand("Bajaj").build());
        System.out.println(vehicle4Wheeler);
        System.out.println(vehicle2Wheeler);
    }

}
