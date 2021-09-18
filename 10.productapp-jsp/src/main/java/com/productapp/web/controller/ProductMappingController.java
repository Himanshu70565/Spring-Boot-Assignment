package com.productapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@Controller
public class ProductMappingController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/showAllProducts")
	public String showAllProducts(ModelMap model) {
		model.addAttribute("products", productService.getAllProducts());
		return "showAllProducts";
	}

	@GetMapping("/addProduct")
	public String addProductGet(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String addProductPost(@ModelAttribute Product product, Model map) {
		Long id=(product.getProductId());
		if(id==null) {
			productService.addProduct(product);
		}else {
			productService.updateProduct(id, product);
		}
		return "redirect:showAllProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam (name="id") int id,Model map) {
		productService.deleteProduct(id);
		return "redirect:showAllProducts";
	}

	@GetMapping("/updateProduct")
	public String updateProductGet(@RequestParam (name="id") int id,Model map) {
		Product productToBeUpdated = productService.getProductById(id);	
		map.addAttribute("product", productToBeUpdated);
		return "updateProduct";
	}
	

}
