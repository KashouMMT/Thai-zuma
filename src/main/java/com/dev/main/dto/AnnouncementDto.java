package com.dev.main.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AnnouncementDto {
	
	@NotBlank(message = "Title must not be empty")
	@Size(message = "Title must be less than 100",max = 100,min = 0)
	private String title;
	
	@NotBlank(message = "Content must not be empty")
	private String content;
	
	private String url;
	
	private MultipartFile image;
	
	private String imageName;
	
	public AnnouncementDto() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
