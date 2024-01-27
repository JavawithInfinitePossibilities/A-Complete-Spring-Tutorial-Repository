/**
 * 
 */
package com.tutorials.sid.spring.controller.ormcntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.sid.spring.module.Product;
import com.tutorials.sid.spring.module.dto.ProductDto;
import com.tutorials.sid.spring.services.productsrvs.IProductServices;

/**
 * @author Lenovo<br/>
 *         URL is :
 *         http://localhost:8080/Chapter-23-Java-Configuration/product/show
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	@Qualifier("productServicesimpl")
	private IProductServices productServices;

	@RequestMapping("/show")
	public String showProductRegPage() {
		return "productregistrationpage";
	}

	@RequestMapping(value = "/productregistration", method = RequestMethod.POST)
	public ModelAndView productRegistrationPage(@ModelAttribute("Product") ProductDto product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productverification");
		modelAndView.addObject("product", product);
		return modelAndView;
	}

	@RequestMapping(value = "/productverificationconfirm")
	public String productEditRegistrationPage(@RequestParam(value = "productname", required = false) String name,
			@RequestParam(value = "productdescription", required = false) String description,
			@RequestParam(value = "productprice", required = false) double price, ModelMap modelMap) {
		System.out.println("name=" + name + ", description=" + description + ", email=" + price);
		int productId = productServices.create(name, description, price);
		modelMap.addAttribute("productid", productId);
		modelMap.addAttribute("productname", name);
		return "productsavedandconfirm";
	}

	@RequestMapping(value = "/showallproduct")
	public String showAllProductPage(ModelMap modelMap) {
		List<Product> loadAllProduct = productServices.loadAllProduct();
		modelMap.addAttribute("allproductDetails", loadAllProduct);
		return "showallproductpage";
	}

	@RequestMapping(value = "/validateproductname")
	public @ResponseBody String getProductPage(@RequestParam("name") String name) {
		System.out.println("...This is validation method...");
		List<Product> loadAllProduct = productServices.getProduct(name);
		System.out.println("All product : " + loadAllProduct);
		String mesage = "";
		if (loadAllProduct != null && !loadAllProduct.isEmpty() && loadAllProduct.get(0) != null) {
			mesage = loadAllProduct.get(0).getName() + " name already exist...";
		}
		System.out.println(mesage);
		return mesage;
	}
}
