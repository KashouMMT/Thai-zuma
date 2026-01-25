package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.main.service.BlogService;

@Controller
@RequestMapping("/{lang}/home")
public class NewsController {
	
	private final BlogService blogService;

	public NewsController(BlogService blogService) {
		super();
		this.blogService = blogService;
	}

	@GetMapping("/blog")
	public String blogsPage(Model model) {
		model.addAttribute("metaTitle","meta.title.news");
		model.addAttribute("metaDescription","meta.description.news");
		model.addAttribute("blogs",blogService.getAllBlogsOrderedByUpdatedAt());
		model.addAttribute("content","public/content/news");
		model.addAttribute("canonical","/blog");
		
		return "public/public-layout";
	}
}
