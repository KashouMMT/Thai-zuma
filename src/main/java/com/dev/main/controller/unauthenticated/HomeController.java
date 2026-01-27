package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.main.service.BlogService;

@Controller
@RequestMapping("/{lang}/home")
public class HomeController {

	private final BlogService blogService;
	
	public HomeController(BlogService blogService) {
		super();
		this.blogService = blogService;
	}

	@GetMapping({"","/"})
	public String homePage(Model model) {
		model.addAttribute("blogs",blogService.getFirstBlogAsList());
		model.addAttribute("isButtonShown",true);	
		model.addAttribute("metaTitle","meta.title");
		model.addAttribute("metaDescription","meta.description");
		model.addAttribute("content","public/content/home");
		model.addAttribute("canonical","/home");
		
		return "public/public-layout";
	}
}
