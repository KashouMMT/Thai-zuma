package com.dev.main.controller.other;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dev.main.utils.LangPathUtils;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalModelAttributes {
	
	@ModelAttribute("currentUri")
	public String currentUri(HttpServletRequest request) {
		return request.getRequestURI();
	}
	
	@ModelAttribute("currentLang")
	public String currentLang(HttpServletRequest request) {
		return LangPathUtils.resolveLangFromPath(request);
	}
}
