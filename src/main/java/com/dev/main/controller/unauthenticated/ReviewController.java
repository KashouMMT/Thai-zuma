package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class ReviewController {

	@GetMapping("/review")
	public String getReviewPage(Model model) {
		model.addAttribute("content","public/content/review");
		model.addAttribute("metaTitle","meta.title.review");
		model.addAttribute("metaDescription","meta.description.review");
		model.addAttribute("canonical","/review");
		return "public/public-layout";
	}
}
