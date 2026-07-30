package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Product;
import com.tutorials.sid.spring.repositories.IProductMogRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * Unit test for simple Section22WorkingWithMongoDB.
 */
@SpringBootTest(classes = Section22WorkingWithMongoDB.class)
public class Section22WorkingWithMongoDBTest {
    @Autowired
    private IProductMogRepo iProductMogRepo;




    @Disabled
    @Test
    void testProductLoads() {
        Product product = new Product();
        product.setName("orange");
        product.setPrice(1000d);
        Product saveProduct = iProductMogRepo.save(product);
        System.out.println("Save product: " + saveProduct.getId());
    }

    @Disabled
    @Test
    public void testFindAll() {
        List<Product> findAll = iProductMogRepo.findAll();
        findAll.stream().forEach(p -> {
            System.out.println(p.getName());
        });
    }

    @Disabled
    @Test
    public void testDeleteAll() {
        iProductMogRepo.deleteById("5f774d2acc50c570a29cc8e9");
    }

}
