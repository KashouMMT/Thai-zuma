package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}/home")
public class JobListingController {
	
	@GetMapping("/job-listing")
	public String getJobListingPage(Model model) {
		model.addAttribute("content","public/content/job-listing");
		model.addAttribute("metaTitle","meta.title.job-listing");
		model.addAttribute("metaDescription","meta.description.job-listing");
		model.addAttribute("canonical","/job-listing");
		return "public/public-layout";
	}
}
