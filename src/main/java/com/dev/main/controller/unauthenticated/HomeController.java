package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.main.service.CategoryService;
import com.dev.main.service.ProductService;

@Controller
@RequestMapping("/{lang}/home")
public class HomeController {
	
	private final ProductService productService;
	private final CategoryService categoryService;

	public HomeController(ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping({"","/"})
	public String homePage(Model model) {
		
		model.addAttribute("productsAll",productService.getAllProducts());
		model.addAttribute("products",productService.getAllFeaturedProductsOrderByFeaturedAt());
		model.addAttribute("categories",categoryService.getAllCategoriesWithFourFeaturedProducts());
		model.addAttribute("metaTitle","meta.title");
		model.addAttribute("metaDescription","meta.description");
		model.addAttribute("content","public/content/home");
		model.addAttribute("canonical","/home");
		
		return "public/public-layout";
	}
}
