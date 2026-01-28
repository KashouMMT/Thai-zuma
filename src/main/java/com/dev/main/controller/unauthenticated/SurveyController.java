package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class SurveyController {
	
	@GetMapping("/survey")
	public String surveyFormPage(Model model) {
		model.addAttribute("metaTitle","meta.title.news");
		model.addAttribute("metaDescription","meta.description.news");
		model.addAttribute("content","public/content/survey");
		model.addAttribute("canonical","/survey");
		return "public/public-layout";
	}
}
