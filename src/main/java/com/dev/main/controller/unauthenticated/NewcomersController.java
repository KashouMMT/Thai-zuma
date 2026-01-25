package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.main.service.ProductService;

@Controller
@RequestMapping("/{lang}/home")
public class NewcomersController {
	private final ProductService productService;

	public NewcomersController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/newcomers")
	public String newcomersPage(Model model) {
		model.addAttribute("productsAll",productService.getAllNewcomerProductsOrderedByUpdatedAt());
		model.addAttribute("metaTitle","meta.title.newcomers");
		model.addAttribute("metaDescription","meta.description.newcomers");
		model.addAttribute("content","public/content/newcomers");
		model.addAttribute("canonical","/newcomers");
		
		return "public/public-layout";
	}
}
