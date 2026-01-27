package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class HowToPlayGuideController {
	
	@GetMapping("/how-to-play")
	public String pricingPage(Model model) {
		model.addAttribute("metaTitle","meta.title.pricing");
		model.addAttribute("metaDescription","meta.description.pricing");
		model.addAttribute("content","public/content/how-to-play");
		model.addAttribute("canonical","/pricing");
		
		return "public/public-layout";
	}
}
