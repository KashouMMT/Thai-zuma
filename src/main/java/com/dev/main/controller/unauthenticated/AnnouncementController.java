package com.dev.main.controller.unauthenticated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.main.service.AnnouncementService;

@Controller
@RequestMapping("/{lang}/home")
public class AnnouncementController {
	
	private final AnnouncementService announcementService;
	
	public AnnouncementController(AnnouncementService announcementService) {
		super();
		this.announcementService = announcementService;
	}
	
	@GetMapping("/news")
	public String getAnnouncementPage(Model model) {
		model.addAttribute("canonical","/news");
		model.addAttribute("content","public/content/announcements");
		model.addAttribute("metaTitle","meta.title.announcement");
		model.addAttribute("metaDescription","meta.description.announcement");
		model.addAttribute("announcements",announcementService.getAllAnnouncements());
		
		return "public/public-layout";
	}
}
