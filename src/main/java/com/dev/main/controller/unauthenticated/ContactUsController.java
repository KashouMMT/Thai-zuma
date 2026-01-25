package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class ContactUsController {

	@GetMapping("/contact-us")
	public String getContactUsPage(Model model) {
		model.addAttribute("content","public/content/contact-us");
		model.addAttribute("metaTitle","meta.title.contact-us");
		model.addAttribute("metaDescription","meta.description.contact-us");
		model.addAttribute("canonical","/contact-us");
		return "public/public-layout";
	}
}
