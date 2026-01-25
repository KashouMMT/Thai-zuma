package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class OptionMenuController {

	@GetMapping("/option-menu")
	public String getOptionMenuPage(Model model) {
		model.addAttribute("content","public/content/option-menu");
		model.addAttribute("metaTitle","meta.title.option-menu");
		model.addAttribute("metaDescription","meta.description.option-menu");
		model.addAttribute("canonical","/option-menu");
		return "public/public-layout";
	}
}
