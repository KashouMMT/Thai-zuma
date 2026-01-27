package com.dev.main.dto;

import com.dev.main.model.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDto {
	
	private Long id;
	
	private Category category;
	
	@NotBlank(message = "Title is required")
	@Size(message = "Title must be less than 150",max = 150)
	private String title;
	
	@Size(message = "Description must be less than 250_000",max = 250000)
	private String description;
	
	@Size(message = "Short Description must be less than 255.",max = 255)
	private String shortDescription;
	
	@NotBlank(message = "Cup size is required")
	@Size(message = "Size must not be less than 20",max = 20)
	private String cupSize;
	
	private Long sortOrder;
	
	public ProductDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
}


