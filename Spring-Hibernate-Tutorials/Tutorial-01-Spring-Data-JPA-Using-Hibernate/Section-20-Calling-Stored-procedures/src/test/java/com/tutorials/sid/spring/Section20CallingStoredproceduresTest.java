package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Product;
import com.tutorials.sid.spring.repositories.IProductRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Unit test for simple Section20CallingStoredprocedures.
 */
@SpringBootTest(classes = Section20CallingStoredprocedures.class)
public class Section20CallingStoredproceduresTest {

    @Autowired
    private IProductRepo iProductRepo;

    @Test
    public void testApp() {
    }

    @Disabled
    @Test
    public void testGetAllProduct() {
        List<Product> saveProduct = iProductRepo.getAllProduct();
        System.out.println(saveProduct);
    }

    @Disabled
    @Test
    public void testReadProduct() {
        List<Product> product = iProductRepo.getAllProductsByPrice(1000);
        System.out.println(product);
    }


    @Test
    public void testUpdateProduct() {
        System.out.println(iProductRepo.getAllProductCountByPrice(4000));
    }
}
