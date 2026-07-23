/**
 *
 */
package com.tutorials.sid.spring.controler.product;

import com.tutorials.sid.spring.entities.Product;
import com.tutorials.sid.spring.repositories.product.IProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lenovo URL :
 *         http://localhost:8080/productmart/productdetails/productSave/ <br/>
 *         { "id": 4, "name": "Ipad", "description": "tablet", "price": 1000 }
 *         http://localhost:8080/productmart/productdetails/products/
 *         http://localhost:8080/productmart/productdetails/productById/2
 *         http://localhost:8080/productmart/productdetails/productById/Ipad
 *
 */
@RestController
@RequestMapping(value = "/productdetails")
@Tag(name = "Product API", description = "Product API")
public class ProductRESTController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRESTController.class);

    @Autowired
    private IProductRepository productRepository;

    @RequestMapping(value = "/products/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all products", description = "Get all products")
    public List<Product> getAllProduct() {
        List<Product> findAll = productRepository.findAll();
        LOGGER.info("Product details: " + findAll);
        return findAll;
    }

    @RequestMapping(value = "/productById/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id) {
        LOGGER.info("Finding product by id : " + id);
        return productRepository.findById(id).get();
    }

    @RequestMapping(value = "/productByName/{name}", method = RequestMethod.GET)
    @Operation(summary = "Get product by name", description = "Get product by name")
    public @ApiResponse(responseCode = "200", description = "Product found") List<Product> getProductByName(@Parameter(description = "Product name") @PathVariable("name") String name) {
        LOGGER.info("Finding product by name : " + name);
        return productRepository.findByName(name);
    }

    @RequestMapping(value = "/productByNameAndPrice/{name}&{price}", method = RequestMethod.GET)
    public List<Product> getProductByNameAndPrice(@PathVariable("name") String name,
                                                  @PathVariable("price") double price) {
        LOGGER.info("Finding product by name : " + name + " and Price :" + price);
        return productRepository.findByNameLikeAndPrice(name, price);
    }

    @RequestMapping(value = "/productSave/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/productUpdate/", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/productDelete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteById(id);
    }
}

