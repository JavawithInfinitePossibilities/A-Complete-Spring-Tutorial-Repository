package com.tutorials.sid.spring.controller.UI;

import com.tutorials.sid.spring.dto.Coupon;
import com.tutorials.sid.spring.model.Product;
import com.tutorials.sid.spring.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * MVC Controller for Product UI pages.
 *      http://localhost:8080/Section-04-Create-Microservices-productservices/productapi/login
 * Routes:
 *   POST /productapi/login
 *   GET  /productapi/              → home.html         (list all products)
 *   GET  /productapi/save          → save-product.html (blank form)
 *   POST /productapi/saveproduct   → saves, then redirects to product-result
 *   GET  /productapi/search        → search-product.html (search form)
 *                                    ?productId=n → redirects to product-result
 *   GET  /productapi/product/{id}  → product-result.html (view one product)
 */
@Controller
@RequestMapping("/productapi")
public class ProductController {

    @Value("${couponservices.uri}")
    private String couponServicesUri;

    @Autowired
    private ProductRepositories productRepositories;

    @Autowired
    private RestTemplate restTemplate;

    // ------------------------------------------------------------------ //
    //  LOGIN – serve the custom login page                                //
    //  Spring Security handles the POST /productapi/login automatically.  //
    //  We only need this GET to render the template.                      //
    // ------------------------------------------------------------------ //
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // ------------------------------------------------------------------ //
    //  HOME – list all products                                            //
    // ------------------------------------------------------------------ //
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("products", productRepositories.findAll());
        return "home";
    }

    // ------------------------------------------------------------------ //
    //  SAVE – show blank form                                              //
    // ------------------------------------------------------------------ //
    @GetMapping("/save")
    public String showSaveForm(Model model) {
        // Provide an empty Product so Thymeleaf th:object binding works
        model.addAttribute("product", new Product());
        return "save-product";
    }

    // ------------------------------------------------------------------ //
    //  SAVE – handle form submission                                       //
    // ------------------------------------------------------------------ //
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product,
                              RedirectAttributes redirectAttributes) {
        try {
            // Call coupon service to apply discount
            Coupon coupon = restTemplate.getForObject(
                    couponServicesUri + product.getCouponCode(), Coupon.class);

            if (coupon != null && coupon.getDiscount() != null) {
                product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
            }

            Product saved = productRepositories.save(product);

            // Pass saved product and flash message via redirect
            redirectAttributes.addFlashAttribute("message",
                    "Product '" + saved.getName() + "' saved successfully!");
            redirectAttributes.addFlashAttribute("product", saved);

            return "redirect:/productapi/product/" + saved.getId();

        } catch (RestClientException ex) {
            // Coupon service unreachable or coupon not found
            redirectAttributes.addFlashAttribute("error",
                    "Could not apply coupon: " + ex.getMessage()
                    + ". Please verify the coupon service is running.");
            redirectAttributes.addFlashAttribute("product", product);
            return "redirect:/productapi/save";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error",
                    "Failed to save product: " + ex.getMessage());
            redirectAttributes.addFlashAttribute("product", product);
            return "redirect:/productapi/save";
        }
    }

    // ------------------------------------------------------------------ //
    //  SEARCH – show search form (GET with no param) OR                   //
    //           handle search (GET with ?productId=n)                     //
    // ------------------------------------------------------------------ //
    @GetMapping("/search")
    public String searchProduct(
            @RequestParam(value = "productId", required = false) Long productId,
            Model model,
            RedirectAttributes redirectAttributes) {

        // No ID provided – just render the search form
        if (productId == null) {
            return "search-product";
        }

        // ID provided – look up and redirect to result page
        Optional<Product> result = productRepositories.findById(productId);
        if (result.isPresent()) {
            redirectAttributes.addFlashAttribute("product", result.get());
            return "redirect:/productapi/product/" + productId;
        } else {
            model.addAttribute("error", "No product found with ID: " + productId);
            return "search-product";
        }
    }

    // ------------------------------------------------------------------ //
    //  RESULT – display a single product (reached via redirect)           //
    // ------------------------------------------------------------------ //
    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable("id") Long id, Model model) {
        // FlashAttributes from redirect are already in model.
        // Only fetch from DB if the flash didn't carry the product.
        if (!model.containsAttribute("product")) {
            Optional<Product> found = productRepositories.findById(id);
            found.ifPresent(p -> model.addAttribute("product", p));
        }
        return "product-result";
    }
}
